package com.cox.vauto.service.impl;

import com.cox.vauto.dao.DealerDAO;
import com.cox.vauto.model.DataSet;
import com.cox.vauto.model.Dealer;
import com.cox.vauto.service.DealerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author, Yonatan,12-07-2018
 */

@Service
public class DealerServiceImpl  implements DealerService {

    private static final Logger log = LoggerFactory.getLogger(DealerServiceImpl.class);

    @Autowired
    DealerDAO dealerDAO;

    @Autowired
    DataSet dataSet;

    @Override
    public Dealer getDealer(int dealerId) {
        log.info("getDealer , With  Data-set >>>" + dataSet);
        return dealerDAO.getDealer(dealerId);
    }
}
