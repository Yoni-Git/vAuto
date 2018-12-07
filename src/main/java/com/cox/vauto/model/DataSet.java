package com.cox.vauto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author, Yonatan,12-07-2018
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataSet {

    private String datasetId;

    public DataSet() {}

    public DataSet(String dataSetId) {
        this.datasetId = dataSetId;
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    @Override
    public String toString() {
        return "DataSet{" +
                "datasetId='" + datasetId + '\'' +
                '}';
    }
}
