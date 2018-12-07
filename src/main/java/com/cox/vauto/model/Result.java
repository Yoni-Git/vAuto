package com.cox.vauto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author, Yonatan,12-07-2018
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    String success;
    String message;
    String totalMilliseconds;

    public Result() {
    }

    public Result(String success, String message, String totalMilliseconds) {
        this.success = success;
        this.message = message;
        this.totalMilliseconds = totalMilliseconds;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTotalMilliseconds() {
        return totalMilliseconds;
    }

    public void setTotalMilliseconds(String totalMilliseconds) {
        this.totalMilliseconds = totalMilliseconds;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success='" + success + '\'' +
                ", message='" + message + '\'' +
                ", totalMilliseconds='" + totalMilliseconds + '\'' +
                '}';
    }
}
