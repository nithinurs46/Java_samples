package manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class VehicleManyToMany {
	
	@Id  @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	@ManyToMany
	private Collection<UserDetailsManyToMany> userList = new ArrayList<UserDetailsManyToMany>();
	
	
	public Collection<UserDetailsManyToMany> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetailsManyToMany> userList) {
		this.userList = userList;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	

}
