package com.example.Helpdeskapp.model;

import javax.persistence.*;

@Entity
@Table(name="Agents")
public class AgentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Agent_id;
    private String name;
    private String email;
    public AgentModel() {
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private CategoryModel categoryModel;

    public Long getAgent_id() {
        return Agent_id;
    }

    public void setAgent_id(Long agent_id) {
        Agent_id = agent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public AgentModel(String name, String email, CategoryModel categoryModel) {
        this.name = name;
        this.email = email;
        this.categoryModel = categoryModel;
    }

    public AgentModel(Long agent_id, String name, String email, CategoryModel categoryModel) {
        Agent_id = agent_id;
        this.name = name;
        this.email = email;
        this.categoryModel = categoryModel;
    }
}
