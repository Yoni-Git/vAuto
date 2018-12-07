package com.cox.vauto.service;

import com.cox.vauto.dto.VehicleDTO;

/**
 * Author, Yonatan,12-07-2018
 */

public interface VehicleService {

    int[] getVehicleIdList();
    VehicleDTO getVehicle(int vehicleId);

    }
