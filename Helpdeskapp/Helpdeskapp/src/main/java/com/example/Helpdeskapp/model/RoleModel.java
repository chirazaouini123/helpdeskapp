package com.example.Helpdeskapp.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Table(name="Role")
public class RoleModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EroleModel getName() {
        return name;
    }

    public void setName(EroleModel name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EroleModel name;
    public RoleModel() {
    }

    public RoleModel(Long id, EroleModel name) {
        this.id = id;
        this.name = name;
    }
}
