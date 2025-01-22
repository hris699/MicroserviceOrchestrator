package com.microflow.orchestrator.service;

import com.microflow.orchestrator.client.MicroserviceClient;
import com.microflow.orchestrator.model.OrchestratorRequest;
import com.microflow.orchestrator.model.Workflow;
import org.springframework.stereotype.Service;
@Service
public class OrchestratorService {
    private final MicroserviceClient microserviceClient;
    public OrchestratorService(MicroserviceClient microserviceClient) {
        this.microserviceClient = microserviceClient;
    }
    public void startOrchestration(OrchestratorRequest request) {
        Workflow workflow = request.getWorkflow();
// Iterate over each service in the workflow and call them sequentially
        for (String serviceUrl : workflow.getServiceUrls()) {
            if (serviceUrl.contains("process")) {
                microserviceClient.callProcessService();
            } else if (serviceUrl.contains("execute")) {
                microserviceClient.callExecuteService();
            } else if (serviceUrl.contains("finish")) {
                microserviceClient.callFinishService();
            }
        }
    }
}