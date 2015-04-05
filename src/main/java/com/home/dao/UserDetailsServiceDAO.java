package com.home.dao;

import com.home.domain.Employee;
import com.home.view.bean.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceDAO implements UserDetailsService {

    @Autowired
    private LoggedInUser loggedInUser;

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = entityManager.createQuery("from Employee where username=:username and enabled = 1")
                .setParameter("username", username);
        final Employee employee = (Employee) query.getSingleResult();
        loggedInUser.setName(employee.getUsername());
        loggedInUser.setRoles(employee.getRoles());
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
                for (int i = 0; i < employee.getRoles().size(); i++) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(employee.getRoles().get(i)));
                }
                return grantedAuthorities;
            }

            @Override
            public String getPassword() {
                return employee.getPassword().trim();
            }

            @Override
            public String getUsername() {
                return employee.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return employee.isEnabled();
            }

            @Override
            public boolean isAccountNonLocked() {
                return employee.isEnabled();
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return employee.isEnabled();
            }

            @Override
            public boolean isEnabled() {
                return employee.isEnabled();
            }
        };
    }
}