package com.example.Helpdeskapp.repository;

import com.example.Helpdeskapp.model.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TicketRepository extends JpaRepository<TicketModel,Long> {
}
