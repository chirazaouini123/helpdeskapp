package com.example.Helpdeskapp.service;

import com.example.Helpdeskapp.exception.ResourcesNotfoundException;
import com.example.Helpdeskapp.model.AgentModel;
import com.example.Helpdeskapp.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AgentServiceImpl implements AgentServiceInterface {
    private AgentRepository agentRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public List<AgentModel> findAllAgents() {
        return agentRepository.findAll();

    }

    @Override
    public AgentModel AddAgent(AgentModel agentmodel) {
        return agentRepository.save(agentmodel);
    }

    @Override
    public AgentModel findAgentById(Long id) {
        return agentRepository.findById(id).orElseThrow(()-> new ResourcesNotfoundException("Agent doesn't exist with id:"+ id));

    }

    @Override
    public AgentModel updateAgent(Long id, AgentModel agentDetails) {
        AgentModel agent=findAgentById(id);
        agent.setName(agentDetails.getName());
        agent.setEmail(agentDetails.getEmail());

        return  agentRepository.save(agent);

    }

    @Override
    public Map<String, Boolean> deleteAgent(Long id) {
        AgentModel agent=findAgentById(id);
        agentRepository.delete(agent);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
