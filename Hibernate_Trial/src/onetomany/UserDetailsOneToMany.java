package onetomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetailsOneToMany {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userID;
	
	@Column(name="USER_NAME") // annotations can be used either above field declaration or above getter method
	private String userName;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//@OneToMany(mappedBy="user")
	@OneToMany(cascade=CascadeType.PERSIST)
	/*@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"), 
									inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))*/
	Collection<VehicleOneToMany> vehicle = new ArrayList<VehicleOneToMany>();

	public Collection<VehicleOneToMany> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleOneToMany> vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
