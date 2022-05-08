package com.example.Helpdeskapp.controller;

import com.example.Helpdeskapp.model.StatusModel;
import com.example.Helpdeskapp.model.TicketModel;
import com.example.Helpdeskapp.service.StatusServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1")

public class StatusController {
private StatusServiceInterface statusServiceInterface;
    @Autowired
    public StatusController(StatusServiceInterface statusServiceInterface) {
        this.statusServiceInterface = statusServiceInterface;
    }
    @GetMapping("/status")
    public ResponseEntity<List<StatusModel>> getAllStatus(){
        List<StatusModel> s= statusServiceInterface.findAllStatus();
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    @PostMapping("/status")
    public ResponseEntity<StatusModel> createTicket(@RequestBody StatusModel statusModel){
        StatusModel status=statusServiceInterface.AddStatus(statusModel);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
    @GetMapping("/status/{id}")
    public ResponseEntity<StatusModel> getStatusById(@PathVariable Long id){
        StatusModel status =statusServiceInterface.findStatusById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }
    @PutMapping("/status/{id}")

    public ResponseEntity<StatusModel> updateStatus(@PathVariable Long id, @RequestBody StatusModel statusModel){
        StatusModel s1=statusServiceInterface.updateStatus(id,statusModel);
        return   new ResponseEntity<>(s1,HttpStatus.OK);
    }
    @DeleteMapping("/status/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStatus(@PathVariable Long id){
        Map<String,Boolean> response=statusServiceInterface.deleteStatus(id);
        return  ResponseEntity.ok(response);
    }



}
