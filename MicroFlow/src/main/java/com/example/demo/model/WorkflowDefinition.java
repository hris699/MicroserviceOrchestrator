package com.example.demo.model;

import java.util.List;

public class WorkflowDefinition {
   private String workflowName;
   private List<ServiceDefinition> services;
   private List<WorkflowStep> steps;
   public String getWorkflowName() {
       return workflowName;
   }
   public void setWorkflowName(String workflowName) {
       this.workflowName = workflowName;
   }
   public List<ServiceDefinition> getServices() {
       return services;
   }
   public void setServices(List<ServiceDefinition> services) {
       this.services = services;
   }
   public List<WorkflowStep> getSteps() {
       return steps;
   }
   public void setSteps(List<WorkflowStep> steps) {
       this.steps = steps;
   }
}