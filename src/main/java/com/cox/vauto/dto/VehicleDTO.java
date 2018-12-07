package com.cox.vauto.dto;

/**
 * Author, Yonatan,12-07-2018
 */

public class VehicleDTO {

        private int vehicleId;
        private int year;
        private String make;
        private String model;
        private int dealerId;

    public VehicleDTO(int vehicleId, int year, String make, String model, int dealerId) {
        this.vehicleId = vehicleId;
        this.year = year;
        this.make = make;
        this.model = model;
        this.dealerId = dealerId;
    }

    public VehicleDTO() {
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "vehicleId=" + vehicleId +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", dealerId=" + dealerId +
                '}';
    }
}
