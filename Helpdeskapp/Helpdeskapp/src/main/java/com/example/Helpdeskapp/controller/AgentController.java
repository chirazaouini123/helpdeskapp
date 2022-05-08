package com.example.Helpdeskapp.controller;

import com.example.Helpdeskapp.model.AgentModel;

import com.example.Helpdeskapp.service.AgentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1")


public class AgentController {
    private final AgentServiceInterface agentService;
    @Autowired

    public AgentController(AgentServiceInterface agentService) {
        this.agentService = agentService;
    }


    @GetMapping("/agents")
    public ResponseEntity<List<AgentModel>> getAllAgents(){
        List<AgentModel> agents= agentService.findAllAgents();
        return new ResponseEntity<>(agents, HttpStatus.OK);
    }
    @PostMapping("/agents")
    public ResponseEntity<AgentModel> createAgent(@RequestBody AgentModel agentModel){
        AgentModel agent=agentService.AddAgent(agentModel);
        return new ResponseEntity<>(agent,HttpStatus.OK);
    }
    @GetMapping("/agents/{id}")
    public ResponseEntity<AgentModel> getAgentById(@PathVariable Long id){
        AgentModel agent =agentService.findAgentById(id);
        return new ResponseEntity<>(agent, HttpStatus.OK);

    }
    @PutMapping("/agents/{id}")

    public ResponseEntity<AgentModel> updateTicket(@PathVariable Long id, @RequestBody AgentModel agentDetails){
        AgentModel agent=agentService.updateAgent(id,agentDetails);
        return   new ResponseEntity<>(agent,HttpStatus.OK);
    }
    @DeleteMapping("/agents/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAgent(@PathVariable Long id){
        Map<String,Boolean> response=agentService.deleteAgent(id);
        return  ResponseEntity.ok(response);
    }
}
