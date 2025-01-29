package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkflowStep {
   private String name;
   private String serviceName;
   private String action;
   private Map<String, Object> input;
   private String nextStep;
   private String onFailure; 
   private String pathParam;
   private String method;
   // New field added
// Getters and setters
   public String getPathParam() {
       return pathParam;
   }
   public void setPathParam(String pathParam) {
       this.pathParam = pathParam;
   }
   public String getMethod() {
       return method;
   }
   public void setMethod(String method) {
       this.method = method;
   }
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
   public String getNextStep() {
       return nextStep;
   }
   public void setNextStep(String nextStep) {
       this.nextStep = nextStep;
   }
   public String getOnFailure() {
       return onFailure;
   }
   public void setOnFailure(String onFailure) {
       this.onFailure = onFailure;
   }
public String getUrl() {
	// TODO Auto-generated method stub
	return null;
}
}