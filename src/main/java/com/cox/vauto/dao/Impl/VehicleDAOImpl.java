package com.cox.vauto.dao.Impl;

import com.cox.vauto.dao.VehicleDAO;
import com.cox.vauto.dto.VehicleDTO;
import com.cox.vauto.dto.VehicleIdDTO;
import com.cox.vauto.model.DataSet;
import com.cox.vauto.service.DealerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import static com.cox.vauto.common.Constants.PATH_SEPARATOR;


/**
 * Author, Yonatan,12-07-2018
 */

@Repository
public class VehicleDAOImpl implements VehicleDAO {


    @Value("${vAuto.base.url}")
    private String BASE_URL;

    @Value("${vehicle.url}")
    private String VEHICLE;

    @Autowired
    DataSet dataSet;

    @Autowired
    DealerService dealerService;

    private static final Logger log = LoggerFactory.getLogger(VehicleDAOImpl.class);


    @Override
    public int[] getVehicleIdList() {
        log.info("getVehicleIdList , Received Data-set >>>" + dataSet);
        RestTemplate restTemplate = new RestTemplate();
        String combinedURL = BASE_URL +  dataSet.getDatasetId()  + PATH_SEPARATOR + VEHICLE;
        log.info("getVehicleIdList , making URL call to " + combinedURL);
        VehicleIdDTO result  = restTemplate.getForObject( combinedURL, VehicleIdDTO.class);
        log.info(result.toString());
        log.info(">>>Get Vehicle ID List END");
        return result.getVehicleIds();

    }

    @Override
    public VehicleDTO getVehicle(int vehicleId) {
        log.info("getVehicle , Received Data-set >>>" + dataSet);
        RestTemplate restTemplate = new RestTemplate();
        String combinedURL = BASE_URL +  dataSet.getDatasetId()  + PATH_SEPARATOR + VEHICLE + PATH_SEPARATOR + vehicleId;
        log.info("getVehicle , making URL call to " + combinedURL);
        VehicleDTO result  = restTemplate.getForObject( combinedURL, VehicleDTO.class);
        log.info(result.toString());
        log.info(">>>Get Vehicle  END");
        return result;
    }
}
