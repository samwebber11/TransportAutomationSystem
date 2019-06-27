package org.sambhav.transport.models;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "driver")
public class TransportDriver implements Serializable{

	private static final long serialVersionUID = -86101426336179691L;

	@Id
	@NotNull
	@Column(name = "driver_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(max = 10)
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@Size(max = 10)
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@Size(max = 15)
	@NotNull
	@Column(name = "user_name")
	private String userName;
	
	@Size(min = 10,max = 10)
	@NotNull
	@Column(name = "vehicle_no")
	private String vehicalNo;
	
	@Column(name = "status")
	private Boolean isAvailable = true;
	
	@Column(name = "booked")
	private Boolean isBooked = false;
	
	@Column(name = "start_location")
	@Size(max = 50)
	private String startingLocation;
	
	@Column(name = "end_location")
	@Size(max = 50)
	private String endingLocation = null;
	
	@Column(name = "phone")
	@Size(min = 10,max = 10)
	private String mobileNumber;
	
	@ManyToMany
	@JoinTable(name = "role_driver_matching", joinColumns = @JoinColumn(name = "driver_id",referencedColumnName = "driver_id"), inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
	private Set<Role> roles;
	
	@OneToOne(mappedBy = "driver")
	private Rides ride;
	
	
	public TransportDriver(@Size(max = 10) @NotNull String firstName, @Size(max = 10) @NotNull String lastName,
			@Size(max = 15) @NotNull String userName, @Size(min = 10, max = 10) @NotNull String vehicalNo,
			Boolean isAvailable, Boolean isBooked, @Size(max = 50) String startingLocation,
			@Size(max = 50) String endingLocation, @Size(min = 10, max = 10) String mobileNumber,
			Set<Role> role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.vehicalNo = vehicalNo;
		this.isAvailable = isAvailable;
		this.isBooked = isBooked;
		this.startingLocation = startingLocation;
		this.endingLocation = endingLocation;
		this.mobileNumber = mobileNumber;
		this.roles = role;
	}
	public TransportDriver() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getVehicalNo() {
		return vehicalNo;
	}
	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Boolean getIsBooked() {
		return isBooked;
	}
	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}
	public String getStartingLocation() {
		return startingLocation;
	}
	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}
	public String getEndingLocation() {
		return endingLocation;
	}
	public void setEndingLocation(String endingLocation) {
		this.endingLocation = endingLocation;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Set<Role> getRole() {
		return roles;
	}
	public void setRole(Set<Role> role) {
		this.roles = role;
	}
	
}
