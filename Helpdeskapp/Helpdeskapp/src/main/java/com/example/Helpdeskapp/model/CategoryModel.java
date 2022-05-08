package com.example.Helpdeskapp.model;

import javax.persistence.*;

@Entity
@Table(name="Categories")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    private String title;
    @OneToOne(mappedBy = "categoryModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AgentModel agentModel ;


    public CategoryModel() {
    }

    public CategoryModel(Long category_id, String title, AgentModel agentModel) {
        this.category_id = category_id;
        this.title = title;
        this.agentModel = agentModel;
    }

    public CategoryModel(String title, AgentModel agentModel) {
        this.title = title;
        this.agentModel = agentModel;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AgentModel getAgentModel() {
        return agentModel;
    }

    public void setAgentModel(AgentModel agentModel) {
        this.agentModel = agentModel;
    }
}
