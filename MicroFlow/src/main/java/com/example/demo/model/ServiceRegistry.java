package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ServiceRegistry {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String serviceName;
   private String url;
   @ElementCollection
   private List<String> supportedActions;
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
this.id = id;
   }
   public String getServiceName() {
       return serviceName;
   }
   public void setServiceName(String serviceName) {
       this.serviceName = serviceName;
   }
   public String getUrl() {
       return url;
   }
   public void setUrl(String url) {
       this.url = url;
   }
   public List<String> getSupportedActions() {
       return supportedActions;
   }
   public void setSupportedActions(List<String> supportedActions) {
       this.supportedActions = supportedActions;
   }
}