package com.cox.vauto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
/**
 * Author, Yonatan,12-07-2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dealer {
    private int dealerId;
    private String name;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Dealer() {
    }

    public Dealer(int dealerId, String name, List<Vehicle> vehicles) {
        this.dealerId = dealerId;
        this.name = name;
        this.vehicles = vehicles;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "dealerId=" + dealerId +
                ", name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
