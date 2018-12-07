package com.cox.vauto.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author, Yonatan,12-07-2018
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    private int vehicleId;
    private int year;
    private String make;
    private String model;


    public Vehicle(int vehicleId, int year, String make, String model) {
        this.vehicleId = vehicleId;
        this.year = year;
        this.make = make;
        this.model = model;

    }

    public Vehicle() {
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


    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
