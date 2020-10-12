package manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetailsManyToMany {

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
	
	@ManyToMany
	private Collection<VehicleManyToMany> vehicle = new ArrayList<VehicleManyToMany>();

	public Collection<VehicleManyToMany> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleManyToMany> vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
