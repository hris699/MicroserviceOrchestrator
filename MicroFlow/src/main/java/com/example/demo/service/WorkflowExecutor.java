package com.example.demo.service;


import com.example.demo.model.WorkflowDefinition;
import com.example.demo.model.WorkflowStep;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class WorkflowExecutor {
   private final RestTemplate restTemplate;
   public WorkflowExecutor(RestTemplate restTemplate) {
       this.restTemplate = restTemplate;
   }
   public void executeWorkflow(WorkflowDefinition workflow) {
       // Map steps by their names for quick lookup
       Map<String, WorkflowStep> stepMap = workflow.getSteps().stream()
               .collect(Collectors.toMap(WorkflowStep::getName, step -> step));
       // Start with the first step
       Optional<WorkflowStep> currentStepOptional = workflow.getSteps().stream().findFirst();
       // Loop through the steps until no nextStep is defined
       while (currentStepOptional.isPresent()) {
           WorkflowStep currentStep = currentStepOptional.get();
           // Execute the current step
           boolean success = executeStep(currentStep);
           // Determine the next step
           if (success) {
               String nextStepName = currentStep.getNextStep();
               currentStepOptional = Optional.ofNullable(nextStepName).map(stepMap::get);
           } else {
               // Handle failure logic (optional)
               System.out.println("Execution failed for step: " + currentStep.getName());
               break;
           }
       }
   }
   private boolean executeStep(WorkflowStep step) {
       try {
           // Construct the service endpoint URL
           String serviceUrl = step.getServiceName() + "/" + step.getAction();
           if(step.getPathParam()!=null ) {
        	   serviceUrl = serviceUrl +"/"+ step.getPathParam();
           }
           // Execute the HTTP call
           System.out.println("url "+serviceUrl);
           Map<String, Object> input = step.getInput();
           System.out.println("Executing step: " + step.getName() + " with input: " + input);
           // Using RestTemplate to call the service
           System.out.println(step.getMethod());
           if(step.getMethod().equals("GET")) {
        	   restTemplate.getForObject(serviceUrl, Void.class);
           }
           else {
        	   restTemplate.postForObject(serviceUrl, input, Void.class);
           }
           
           System.out.println("Step executed successfully: " + step.getName());
           return true;
       } catch (Exception e) {
           System.err.println("Error executing step: " + step.getName() + " - " + e.getMessage());
           if (step.getOnFailure() != null) {
               System.out.println("Redirecting to onFailure step: " + step.getOnFailure());
           }
           return false;
       }
   }
}
