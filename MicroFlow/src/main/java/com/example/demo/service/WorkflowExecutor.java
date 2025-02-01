package com.example.demo.service;

import com.example.demo.model.WorkflowDefinition;
import com.example.demo.model.WorkflowStep;
import com.example.demo.exception.StepExecutionException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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
	    Map<String, WorkflowStep> stepMap = workflow.getSteps().stream()
	            .collect(Collectors.toMap(WorkflowStep::getName, step -> step));
	    Optional<WorkflowStep> currentStepOptional = workflow.getSteps().stream().findFirst();
	    while (currentStepOptional.isPresent()) {
	        WorkflowStep currentStep = currentStepOptional.get();
	        try {
	            boolean success = executeStepWithRetry(currentStep);
	            if (success) {
	                String nextStepName = currentStep.getNextStep();
	                currentStepOptional = Optional.ofNullable(nextStepName).map(stepMap::get);
	            }
	        } catch (StepExecutionException e) {
	            throw new StepExecutionException("Execution failed beacuse of: " + e.getMessage());
	        }
	    }
	}
   private boolean executeStepWithRetry(WorkflowStep step) {
	    int attempt = 0;
	    String errorMessage = null;
	    while (attempt < step.getRetryCount()) {
	        try {
	            executeStep(step);
	            return true;
	        } catch (Exception e) {
	            attempt++;
	            errorMessage = extractErrorMessage(e.getMessage());
	            System.err.println("Attempt " + attempt + " failed for step: " + step.getName() + ". Retrying in " + step.getRetryDelay() + "ms...");
	            System.out.println(errorMessage + " getmessage");
	            try {
	                Thread.sleep(step.getRetryDelay() * attempt);  // Exponential Backoff
	            } catch (InterruptedException ie) {
	                Thread.currentThread().interrupt();
	                throw new StepExecutionException("Retry interrupted for step: " + step.getName());
	            }
	        }
	    }
	    System.err.println("All retries failed for step: " + step.getName()+ " - "+ errorMessage);
	    throw new StepExecutionException(errorMessage != null ? errorMessage : "All retries failed for step: " + step.getName());
	}
   private void executeStep(WorkflowStep step) {
	    try {
	        String serviceUrl = step.getServiceName() + "/" + step.getAction();
	        if (step.getPathParam() != null) {
	            serviceUrl = serviceUrl + "/" + step.getPathParam();
	        }
	        System.out.println("Executing step: " + step.getName() + " with input: " + step.getInput());
	        if (step.getMethod().equalsIgnoreCase("GET")) {
	            restTemplate.getForObject(serviceUrl, Void.class);
	        } else {
	            restTemplate.postForObject(serviceUrl, step.getInput(), Void.class);
	        }
	        System.out.println("Step executed successfully: " + step.getName());
	    } catch (Exception e) {
	        String errorMessage = extractErrorMessage(e.getMessage());
	        System.err.println("Error executing step: " + step.getName() + " - " + errorMessage);
	        throw new StepExecutionException(errorMessage);
	    }
	}
   private String extractErrorMessage(String message) {
	    // Extract the specific error message
	    if (message.contains("Insufficient stock")) {
	        return "Insufficient stock";
	    } else if (message.contains("Product not found in inventory")) {
	        return "Product not found in inventory";
	    }
	    return message;
	}
}
