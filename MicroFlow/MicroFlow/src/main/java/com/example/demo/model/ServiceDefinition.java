package com.example.demo.model;

import java.util.List;

public class ServiceDefinition {
	
   private String serviceName;
   private String url;
   private List<String> supportedActions;
   
   public String getServiceName() {
       return serviceName;
   }
   public void setServiceName(String serviceName) {
       this.serviceName = serviceName;
   }
   public String getUrl() {
       return url;
   }
   public void setUrl(String url) {
       this.url = url;
   }
   public List<String> getSupportedActions() {
       return supportedActions;
   }
   public void setSupportedActions(List<String> supportedActions) {
       this.supportedActions = supportedActions;
   }
}
