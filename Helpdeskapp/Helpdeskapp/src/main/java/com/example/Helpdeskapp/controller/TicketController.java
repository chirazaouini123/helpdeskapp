package com.example.Helpdeskapp.controller;

import com.example.Helpdeskapp.model.TicketModel;
import com.example.Helpdeskapp.service.TicketServiceInterface;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1")

public class TicketController {
    private final TicketServiceInterface ticketService;
    @Autowired
    public TicketController(TicketServiceInterface ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping("/tickets")
    public ResponseEntity<List<TicketModel>> getAllTickets(){
        List<TicketModel> tickets= ticketService.findAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
    @PostMapping("/tickets")
    public ResponseEntity<TicketModel> createTicket(@RequestBody TicketModel ticketModel){
        TicketModel ticket=ticketService.AddTicket(ticketModel);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketModel> getTicketById(@PathVariable Long id){
        TicketModel ticket =ticketService.findTicketById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);

    }
    @PutMapping("/tickets/{id}")

    public ResponseEntity<TicketModel> updateTicket(@PathVariable Long id, @RequestBody TicketModel ticketDetails){
        TicketModel t1=ticketService.updateTicket(id,ticketDetails);
        return   new ResponseEntity<>(t1,HttpStatus.OK);
    }
    @DeleteMapping("/tickets/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteTicket(@PathVariable Long id){
        Map<String,Boolean> response=ticketService.deleteTicket(id);
        return  ResponseEntity.ok(response);
    }
    @GetMapping("tickets1/{id}")
    public ResponseEntity<String> getStatusById(@PathVariable Long id){
        String title= ticketService.getStatusTitle(id);
        return new ResponseEntity<>(title, HttpStatus.OK);
    }
    @GetMapping("tickets2/{id}")
    public ResponseEntity<String> getCategoryById(@PathVariable Long id){
        String title= ticketService.getCategoryTitle(id);
        return new ResponseEntity<>(title, HttpStatus.OK);
    }
    @GetMapping("tickets3/{id}")
    public ResponseEntity<Any> updateStatus(@PathVariable Long id, String status){
        ticketService.updateStatus(id,status);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
