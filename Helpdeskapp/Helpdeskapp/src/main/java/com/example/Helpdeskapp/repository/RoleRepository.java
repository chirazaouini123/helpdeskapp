package com.example.Helpdeskapp.repository;

import com.example.Helpdeskapp.model.EroleModel;
import com.example.Helpdeskapp.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel,Long> {
    Optional<RoleModel> findByName(EroleModel name);
}
