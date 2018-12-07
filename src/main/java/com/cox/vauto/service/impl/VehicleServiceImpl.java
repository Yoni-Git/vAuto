package com.cox.vauto.service.impl;

import com.cox.vauto.dao.VehicleDAO;
import com.cox.vauto.dto.VehicleDTO;
import com.cox.vauto.model.DataSet;
import com.cox.vauto.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author, Yonatan,12-07-2018
 */

@Service
public class VehicleServiceImpl  implements VehicleService {

    @Autowired
    DataSet dataSet;

    @Autowired
    VehicleDAO vehicleDAO;

    private static final Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Override
    public int[] getVehicleIdList() {
        log.info("getVehicleIdList , with Data-set >>>" + dataSet);
        return vehicleDAO.getVehicleIdList();

    }

    @Override
    public VehicleDTO getVehicle(int vehicleId) {
        log.info("getVehicle , Received Data-set >>>" + dataSet);
        return vehicleDAO.getVehicle(vehicleId);
    }

}
