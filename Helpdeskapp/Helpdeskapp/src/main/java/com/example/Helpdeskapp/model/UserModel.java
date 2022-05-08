package com.example.Helpdeskapp.model;




import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name="User")
public class UserModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Email
    private  String email;

    private String password;
    @ManyToMany(fetch= EAGER)
    private Set<RoleModel> roles = new HashSet<>();

    public UserModel(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserModel() {
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
}
