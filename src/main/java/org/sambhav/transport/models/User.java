package org.sambhav.transport.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User_Records")
public class User implements Serializable {
	
	private static final long serialVersionUID = 8234070264463694452L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	@NotNull
	private Integer id;
	
	@Column(name = "first_name")
	@Size(max = 15)
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	@Size(max = 15)
	@NotNull
	private String lastName;
	
	@NotNull
	@Column(name = "user_name")
	@Size(min=6,max = 15)
	private String userName;
	
	
	@Email(message="Please enter a valid email")
	@Column(name = "email",unique = true)
	@NotNull
	private String email;
	
	@Column(name = "mobileNumber")
	@NotNull
	@Size(min = 10, max = 10)
	private String mobileNumber;
	
	@Column(name = "passwd")
	@Size(min = 4, max = 10 , message = "Your Password must be between 4 and 10 characters")
	private String passwd;
	
	@Size(min = 4,max = 10, message = "Your password must match!!!")
	@Column(name = "confirm_passwd")
	@Transient
	private String confirmPasswd;
	
	@OneToOne(mappedBy = "user")
	private Rides ride;

	@ManyToMany
	@JoinTable(name = "role_user_matching", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	//	Constructors
	public User( @Size(max = 15) @NotNull String firstName, @Size(max = 15) @NotNull String lastName,
		@NotNull @Size(min = 6, max = 15) String userName,
		@Email(message = "Please enter a valid email") @NotNull String email,
		@NotNull @Size(min = 10, max = 10) String mobileNumber, @Size(min = 4, max = 10) String passwd,
		@Size(min = 4, max = 10) String confirmPasswd,Rides ride,Set<Role> roles) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.passwd = passwd;
	this.confirmPasswd = confirmPasswd;
	this.ride = ride;
	this.roles = roles;
	}

	public User()
	{
		
	}
	
	public Rides getRide() {
		return ride;
	}

	public void setRide(Rides ride) {
		this.ride = ride;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getConfirmPasswd() {
		return confirmPasswd;
	}
	public void setConfirmPasswd(String confirmPasswd) {
		this.confirmPasswd = confirmPasswd;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}


