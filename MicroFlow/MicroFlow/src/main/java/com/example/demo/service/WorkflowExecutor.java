package com.example.demo.service;

import com.example.demo.model.WorkflowDefinition;
import com.example.demo.model.WorkflowStep;
import org.springframework.stereotype.Service;
@Service
public class WorkflowExecutor {
   public void executeWorkflow(WorkflowDefinition workflow) {
       for (WorkflowStep step : workflow.getSteps()) {
           System.out.println("Executing Step: " + step.getName());
           System.out.println("Service: " + step.getServiceName());
           System.out.println("Action: " + step.getAction());
           System.out.println("Input: " + step.getInput());
           // Simulate execution logic here.
       }
   }
}