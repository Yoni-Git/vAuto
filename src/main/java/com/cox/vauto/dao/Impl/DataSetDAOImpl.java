package com.cox.vauto.dao.Impl;

import com.cox.vauto.dao.DataSetDAO;
import com.cox.vauto.model.DataSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


/**
 * Author, Yonatan,12-07-2018
 */


@Repository
public class DataSetDAOImpl implements DataSetDAO {
    @Autowired
    DataSet dataSet;

    @Value("${vAuto.base.url}")
    private String BASE_URL;

    @Value("${dataset.url}")
    private String DATA_SET;

    private static final Logger log = LoggerFactory.getLogger(DataSetDAOImpl.class);

    @Override
    public DataSet getDataSet() {
        log.info("DataSetDAO , Previous Data-set >>>" + dataSet);
        RestTemplate restTemplate = new RestTemplate();
        String combinedURL = BASE_URL + "/" + DATA_SET ;
        DataSet result  = restTemplate.getForObject( combinedURL, DataSet.class);
        log.info(result.toString());
        return result;

    }
}
