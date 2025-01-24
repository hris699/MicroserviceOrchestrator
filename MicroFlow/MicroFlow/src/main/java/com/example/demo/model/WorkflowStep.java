package com.example.demo.model;

import java.util.Map;

public class WorkflowStep {
	
   private String name;
   private String serviceName;
   private String action;
   private Map<String, Object> input;
   
   
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public String getServiceName() {
       return serviceName;
   }
   public void setServiceName(String serviceName) {
       this.serviceName = serviceName;
   }
   public String getAction() {
       return action;
   }
   public void setAction(String action) {
       this.action = action;
   }
   public Map<String, Object> getInput() {
       return input;
   }
   public void setInput(Map<String, Object> input) {
       this.input = input;
   }
}
