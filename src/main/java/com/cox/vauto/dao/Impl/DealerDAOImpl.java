package com.cox.vauto.dao.Impl;

import com.cox.vauto.dao.DealerDAO;
import com.cox.vauto.model.DataSet;
import com.cox.vauto.model.Dealer;
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
public class DealerDAOImpl implements DealerDAO {
    private static final Logger log = LoggerFactory.getLogger(DealerDAOImpl.class);

    @Value("${vAuto.base.url}")
    private String BASE_URL;

    @Value("${dealer.url}")
    private String DEALER;

    @Autowired
    DataSet dataSet;

    @Override
    public Dealer getDealer(int dealerId) {
        log.info("getDealer , with Data-set >>>" + dataSet);
        RestTemplate restTemplate = new RestTemplate();
        String combinedURL = BASE_URL +  dataSet.getDatasetId()  + PATH_SEPARATOR + DEALER + PATH_SEPARATOR + dealerId;
        log.info("getDealer , making URL call to " + combinedURL);
        Dealer result  = restTemplate.getForObject( combinedURL, Dealer.class);
        log.info(result.toString());
        return result;
    }
}
