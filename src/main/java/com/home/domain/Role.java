package com.home.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Roles")
public class Role implements Serializable{
    @Id
    private String username;
    @Id
    private String role;

    public String getRole() {
        return role;
    }
}
