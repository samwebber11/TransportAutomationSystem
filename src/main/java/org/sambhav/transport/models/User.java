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
@Table(name = "User_Records")
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
	@Column(name = "user_name")
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
	
	@Column(name = "passwd")
	@Length(min = 4,message = "*Your Password must be between 4 and 10 characters")
	private String passwd;
	
	@Length(min = 4,message = "*Your password must match!!!")
	@Column(name = "confirm_passwd")
	@Transient
	private String confirmPasswd;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
	private Rides ride;

	@ManyToMany
	@JoinTable(name = "role_user_matching", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
//	 Definition of constructors is defined here

	public User(Integer id, @Size(max = 15, message = "*Your first name is not correct") @NotNull String firstName,
			@Size(max = 15, message = "*Your Last name is not correct") @NotNull String lastName,
			@NotNull(message = "*Please provide a valid email") @Size(min = 6, max = 15) String userName,
			@Email(message = "*Please enter a valid email") @NotNull String email,
			@NotNull @Size(min = 10, max = 10, message = "*Please enter a valid phone number") String mobileNumber,
			@Size(min = 4, max = 10, message = "*Your Password must be between 4 and 10 characters") String passwd,
			@Size(min = 4, max = 10, message = "*Your password must match!!!") String confirmPasswd, Rides ride,
			Set<Role> roles) {
		this.id = id;
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


