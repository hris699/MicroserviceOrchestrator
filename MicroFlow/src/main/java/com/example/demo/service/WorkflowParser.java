package com.example.demo.service;

import com.example.demo.model.WorkflowDefinition;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Service;

@Service
public class WorkflowParser {
	
   private final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
   private final ObjectMapper jsonMapper = new ObjectMapper();
   
   public WorkflowDefinition parseWorkflow(String content, String format) throws Exception {
       if ("yaml".equalsIgnoreCase(format)) {
           return yamlMapper.readValue(content, WorkflowDefinition.class);
       } else if ("json".equalsIgnoreCase(format)) {
           return jsonMapper.readValue(content, WorkflowDefinition.class);
       } else {
           throw new IllegalArgumentException("Unsupported format: " + format);
       }
   }
}
