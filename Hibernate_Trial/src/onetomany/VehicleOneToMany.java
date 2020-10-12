package onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VehicleOneToMany {
	
	@Id  @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetailsOneToMany user;
	
	public UserDetailsOneToMany getUser() {
		return user;
	}
	public void setUser(UserDetailsOneToMany user) {
		this.user = user;
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
