package com.home.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private String username;
    @Column
    private String password;
    @Column
    private boolean enabled;

    @JoinColumn(name = "username")
    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<String> getRoles() {
        List<String> roleList = new ArrayList();
        for (int i = 0; i < roles.size(); i++) {
            roleList.add(roles.get(i).getRole());
        }
        return roleList;
    }
}
