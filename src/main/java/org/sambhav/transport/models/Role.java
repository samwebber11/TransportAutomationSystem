package org.sambhav.transport.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
public class Role implements Serializable{
    
	private static final long serialVersionUID = -1243885614767629076L;

	@Id
	@NotNull
	@Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotNull
	@Column(name = "role_name")
	@Size(max = 15)
    private String name;

	@ManyToMany(mappedBy = "roles")
	private Set<User> user;
	
	@ManyToMany(mappedBy = "roles")
	private Set<TransportDriver> driver;

	public Role(@NotNull @Size(max = 15) String name, Set<User> user, Set<TransportDriver> driver) {
		this.name = name;
		this.user = user;
		this.driver = driver;
	}

	public Role() {
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Set<TransportDriver> getDriver() {
		return driver;
	}

	public void setDriver(Set<TransportDriver> driver) {
		this.driver = driver;
	}

	public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

}
