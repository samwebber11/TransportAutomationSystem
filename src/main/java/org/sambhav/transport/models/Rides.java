package org.sambhav.transport.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ride_tracker")
public class Rides implements Serializable{
	
	private static final long serialVersionUID = 9163558714991514059L;

	@Id
	@NotNull
	@Column(name = "ride_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "driver_id")
	private TransportDriver driver;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "end_time")
	private Date endTime;
	
	
	@Column(name = "start_trip")
	private String startLocation;
	
	@Column(name = "end_trip")
	private String endLocation;
	
	@Column(name="total_charge")
	private Double payment;
	

	public Rides(@NotNull Integer id, User user, TransportDriver driver, Date startTime, Date endTime,
			@NotNull(message = "*Your location is not valid") String startLocation, String endLocation,Double payment) {
		this.id = id;
		this.user = user;
		this.payment = payment;
		this.driver = driver;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}

	public Rides()
	{
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TransportDriver getDriver() {
		return driver;
	}

	public void setDriver(TransportDriver driver) {
		this.driver = driver;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	
	public Double getPayment() {
		return this.payment;
	}
	
	public void setPayment(Double payment)
	{
		this.payment = payment;
	}
}
