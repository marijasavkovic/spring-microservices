package com.master.authservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

import com.master.authservice.sheard.domain.BaseEntity;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @ManyToMany
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns =
    @JoinColumn(name = "authority"))
    private List<AuthorityEntity> authorities;

    @JoinColumn(name = "employee_id")
    private Long employeeId;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String email, List<AuthorityEntity> authorities, Long employeeId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.employeeId = employeeId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AuthorityEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void addAuthority(AuthorityEntity authorityEntity) {
        if (authorityEntity != null) {
            if(getAuthorities().contains(authorityEntity)) {
                getAuthorities().set(getAuthorities().indexOf(authorityEntity), authorityEntity);
            }
            else {
                getAuthorities().add(authorityEntity);
            }
        }
    }

    public void removeAuthority(AuthorityEntity authorityEntity) {
        getAuthorities().remove(authorityEntity);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", authorities=" + authorities +
                ", employeeId=" + employeeId +
                '}';
    }
}
