package com.cox.vauto.service.impl;

import com.cox.vauto.dto.DealerDTO;
import com.cox.vauto.dto.VehicleDTO;
import com.cox.vauto.model.DataSet;
import com.cox.vauto.model.Dealer;
import com.cox.vauto.model.Result;
import com.cox.vauto.model.Vehicle;
import com.cox.vauto.service.CoreEngine;
import com.cox.vauto.service.DealerService;
import com.cox.vauto.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 9 is chosen as the data size of vehicles is usually 9.
 */
import static com.cox.vauto.common.Constants.PATH_SEPARATOR;
import static com.cox.vauto.common.Constants.THREAD_COUNT;

@Service
public class CoreEngineImpl  implements CoreEngine {
    /**
     * Author: Yonatan, 12-07-2018
     * This class is a Core Engine for the whole application that acts as an orchestrator
     * uses two services vehicleService / dealerService
     * Steps:
     * 1. Gets all Vehicle Ids - Nothing to optimize here
     * 2. Gets all Vehicle details - Uses Thread for each vehicle (essentially cuts time ) - Maximum Thread is 9 / Average Data size of vehicles
     * Rest of implementation dnt need to be executed with multi thread
     * 3. after vachels are gathered , comes now aggregation. forEach loop adds these vehicles to a map of Dealers
     *
     * Avg. Running Time : 08.2 Sec. :)
     */

    @Autowired
    VehicleService vehicleService;

    @Autowired
    DealerService dealerService;

    @Value("${vAuto.base.url}")
    private String BASE_URL;

    @Value("${answer.url}")
    private String ANSWER;

    @Autowired
    DataSet dataSet;



    private static final Logger log = LoggerFactory.getLogger(CoreEngineImpl.class);


    /**
     * Aggregator
     */
    public DealerDTO aggregate(){
        /**
         * variable Initialization
         */

        Map<Integer, Dealer> dealers = new ConcurrentHashMap<>();
        Map<Integer, VehicleDTO> vehicleDTOs = new ConcurrentHashMap<>();
        Set<Integer> dealerIds = new HashSet<>();
        int [] vehicleIds  = vehicleService.getVehicleIdList();

        log.info("Getting dealers with dataset " + dataSet);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Callable<Void>> tasks = new ArrayList<>();
        for(int vehicleId : vehicleIds) {
            tasks.add(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    VehicleDTO vehicleDTO = vehicleService.getVehicle(vehicleId);

                    vehicleDTOs.put(vehicleId,vehicleDTO);
                    log.info("Logging the VehicleDTOs>>>>" + vehicleDTOs.toString());
                    dealerIds.add(vehicleDTO.getDealerId());
                    if (!dealers.containsKey(vehicleDTO.getDealerId())) {
                        dealers.put(vehicleDTO.getDealerId(), dealerService.getDealer(vehicleDTO.getDealerId()));
                    }

                    return null;
                }
            });

        }
        try {
            executor.invokeAll(tasks);
        } catch(Exception exc) {
            log.error("Error while invoking tasks " + exc.getMessage());
        }
        executor.shutdown();

        ((ConcurrentHashMap<Integer, VehicleDTO>) vehicleDTOs).forEach((key,vehicleDTO) -> {

            Dealer dealer = dealers.get(vehicleDTO.getDealerId());
            dealer.getVehicles().add(new Vehicle(
                            vehicleDTO.getVehicleId(),
                            vehicleDTO.getYear(),
                            vehicleDTO.getMake(),
                            vehicleDTO.getModel()
                    )
            );
            log.info(">>>> Adding Vehicle " + vehicleDTO);
        });

        log.info(">>>> Execution Ended" + dealers);

        return new DealerDTO( new ArrayList<>(dealers.values()));



    }

    public Result submitAnswer(DealerDTO dealers){
        log.info("submitting Answer ,with Data-set >>>" + dataSet);
        Result result = new Result();

        try
        {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            String combinedUrl = new String(BASE_URL +  dataSet.getDatasetId()  + PATH_SEPARATOR + ANSWER);
            result  = restTemplate.postForObject(combinedUrl, dealers, Result.class);
            log.info("Result:  " + result.toString());
        }
        catch (HttpClientErrorException e)
        {
            log.error("error:  " + e.getResponseBodyAsString());

        }
        catch(Exception e)
        {
            log.error("error:  " + e.getMessage());
        }
        finally {
            log.info("*************** Merry X-MAS & Happy Holidays :)  *************");
        }
        return result;

    }



}
