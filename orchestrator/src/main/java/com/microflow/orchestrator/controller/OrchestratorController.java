package com.microflow.orchestrator.controller;

import com.microflow.orchestrator.model.OrchestratorRequest;
import com.microflow.orchestrator.service.OrchestratorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrchestratorController {
    private final OrchestratorService orchestratorService;
    public OrchestratorController(OrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }
    @PostMapping("/orchestrate")
    public String orchestrate(@RequestBody OrchestratorRequest request) {
        orchestratorService.startOrchestration(request);
        return "Orchestration started!";
    }
}
