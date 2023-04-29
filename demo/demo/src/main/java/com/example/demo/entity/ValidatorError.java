package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ValidatorError {

    private List<String> errorMess = new ArrayList<String>();
    private String status;

    public List<String> getErrorMess() {
        return errorMess;
    }

    public void addErrorMess(String errorMessage) {
        this.errorMess.add(errorMessage);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


