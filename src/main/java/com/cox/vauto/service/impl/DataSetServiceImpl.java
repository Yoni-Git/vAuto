package com.cox.vauto.service.impl;

import com.cox.vauto.dao.DataSetDAO;
import com.cox.vauto.model.DataSet;
import com.cox.vauto.service.DataSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Author, Yonatan,12-07-2018
 */

@Service
public class DataSetServiceImpl implements DataSetService {

    @Autowired
    DataSet dataSet;

    @Autowired
    DataSetDAO dataSetDAO;

    private static final Logger log = LoggerFactory.getLogger(DataSetServiceImpl.class);

    @Override
    public void resetDataSetId() {
        log.info("resetDataSetId , Previous Data-set >>>" + dataSet);
        dataSet.setDatasetId(dataSetDAO.getDataSet().getDatasetId());

    }
}
