package org.sambhav.transport.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 8234070264463694452L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name = "first_name")
	@Length(max = 15,message="*Your first name is not correct")
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	@Length(max = 15,message="*Your Last name is not correct")
	@NotNull
	private String lastName;
	
	@NotNull(message="*Please provide a valid email")
	@Column(name = "name")
	@Length(min=6,max = 15)
	private String userName;
	
	
	@Email(message="*Please enter a valid email")
	@Column(name = "email",unique = true)
	@NotNull
	private String email;
	
	@Column(name = "mobileNumber")
	@NotNull
	@Length(min = 10, max = 10,message="*Please enter a valid phone number")
	private String mobileNumber;
	
	@Column(name = "password")
	@Length(min = 4,message = "*Your Password must be between 4 and 10 characters")
	private String password;
	
	@Length(min = 4,message = "*Your password must match!!!")
	@Column(name = "confirm_password")
	@Transient
	private String confirmPassword;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
	private Rides ride;

	@ManyToMany
	@JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@Column(name="active")
	private int active;
	
//	 Definition of constructors is defined here

	public User(Integer id, @Length(max = 15, message = "*Your first name is not correct") @NotNull String firstName,
			@Length(max = 15, message = "*Your Last name is not correct") @NotNull String lastName,
			@NotNull(message = "*Please provide a valid email") @Length(min = 6, max = 15) String userName,
			@Email(message = "*Please enter a valid email") @NotNull String email,
			@NotNull @Length(min = 10, max = 10, message = "*Please enter a valid phone number") String mobileNumber,
			@Length(min = 4, message = "*Your Password must be between 4 and 10 characters") String password,
			@Length(min = 4, message = "*Your password must match!!!") String confirmPassword, Rides ride,
			Set<Role> roles, int active) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.ride = ride;
		this.roles = roles;
		this.active = active;
	}
	
	public User()
	{
		
	}
	
//	Below is the list of getters and setters 
	
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
	
	public int getActive() {
		return active;
	}
	
	public void setActive(int active)
	{
		this.active = active;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}


