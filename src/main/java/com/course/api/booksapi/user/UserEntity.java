package com.course.api.booksapi.user;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Column(name = "Username")
    @Id
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AuthoritiesEntity> authoritiesEntities;

    public UserEntity() {
    }

    public UserEntity(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AuthoritiesEntity> getAuthoritiesEntities() {
        return authoritiesEntities;
    }

    public void setAuthoritiesEntities(Set<AuthoritiesEntity> authoritiesEntities) {
        this.authoritiesEntities = authoritiesEntities;
    }
}
