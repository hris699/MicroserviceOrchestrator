package com.microflow.orchestrator.model;

import java.util.List;

public class Workflow {
    private List<String> serviceUrls;
    // Getters and Setters
    public List<String> getServiceUrls() {
        return serviceUrls;
    }
    public void setServiceUrls(List<String> serviceUrls) {
        this.serviceUrls = serviceUrls;
    }
}
