package com.cox.vauto.dto;

import java.util.Arrays;

/**
 * Author, Yonatan,12-07-2018
 */

public class VehicleIdDTO {
    private int [] vehicleIds;

    public VehicleIdDTO() {
    }

    public VehicleIdDTO(int[] vehicleIds) {
        this.vehicleIds = vehicleIds;
    }

    public int[] getVehicleIds() {
        return vehicleIds;
    }

    public void setVehicleIds(int[] vehicleIds) {
        this.vehicleIds = vehicleIds;
    }

    @Override
    public String toString() {
        return "VehicleIdDTO{" +
                "vehicleIds=" + Arrays.toString(vehicleIds) +
                '}';
    }
}
