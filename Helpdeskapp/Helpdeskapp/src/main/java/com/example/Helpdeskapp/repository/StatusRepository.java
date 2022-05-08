package com.example.Helpdeskapp.repository;

import com.example.Helpdeskapp.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel,Long> {
}
