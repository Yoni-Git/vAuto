package com.cox.vauto.dto;

import com.cox.vauto.model.Dealer;

import java.util.List;

/**
 * Author, Yonatan,12-07-2018
 */

public class DealerDTO {

    private List<Dealer> dealers;


    public DealerDTO() {
    }

    public DealerDTO( List<Dealer> dealers) {
        this.dealers = dealers;
    }

    public List<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(List<Dealer> dealers) {
        this.dealers = dealers;
    }

    @Override
    public String toString() {
        return "DealerDTO{" +
                "dealers=" + dealers +
                '}';
    }
}
