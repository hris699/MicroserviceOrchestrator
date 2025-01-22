package com.microflow.orchestrator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "microservice-client", url = "${microservice.url}")
public interface MicroserviceClient {
    @PostMapping("/api/process")
    String callProcessService();
    @PostMapping("/api/execute")
    String callExecuteService();
    @PostMapping("/api/finish")
    String callFinishService();
}
