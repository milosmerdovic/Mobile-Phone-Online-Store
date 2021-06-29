package com.test.demo.entity;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @NotEmpty(message = "*Please provide your name")
    private String name;
    
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Email is mandatory!")
    private String email;
    
    @NotEmpty(message = "*Address is mandatory!")
    private String address;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Collection<Role> roles;
	

	public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
    	return address;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public Collection<Role> getRoles() {
        return roles;
    }
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }


}