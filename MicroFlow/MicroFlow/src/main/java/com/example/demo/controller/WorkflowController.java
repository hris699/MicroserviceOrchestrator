package com.example.demo.controller;

import com.example.demo.model.WorkflowDefinition;
import com.example.demo.service.ServiceRegistryManager;
import com.example.demo.service.WorkflowExecutor;
import com.example.demo.service.WorkflowParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {
	
   @Autowired
   private WorkflowParser workflowParser;
   
   @Autowired
   private ServiceRegistryManager serviceRegistryManager;
   
   @Autowired
   private WorkflowExecutor workflowExecutor;
   
   @PostMapping("/execute")
   public ResponseEntity<String> executeWorkflow(@RequestBody String workflowContent,
                                                 @RequestParam String format) {
       try {
           WorkflowDefinition workflow = workflowParser.parseWorkflow(workflowContent, format);
           // Register services
           workflow.getServices().forEach(serviceRegistryManager::registerService);
           // Execute workflow
           workflowExecutor.executeWorkflow(workflow);
           return ResponseEntity.ok("Workflow executed successfully.");
       } catch (Exception e) {
           return ResponseEntity.badRequest().body("Error executing workflow: " + e.getMessage());
       }
   }
}