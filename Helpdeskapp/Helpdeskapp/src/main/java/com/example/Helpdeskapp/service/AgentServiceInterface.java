package com.example.Helpdeskapp.service;

import com.example.Helpdeskapp.model.AgentModel;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;
public interface AgentServiceInterface {
    public List<AgentModel> findAllAgents();
    public AgentModel AddAgent( AgentModel agentmodel);
    public AgentModel findAgentById( Long id);
    public AgentModel updateAgent(Long id,  AgentModel agentDetails);
    public Map<String,Boolean> deleteAgent(Long id);
}
