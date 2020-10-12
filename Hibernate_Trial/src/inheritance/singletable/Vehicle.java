package inheritance.singletable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="VEHICLE_SINGLE")
@Inheritance(strategy=InheritanceType.JOINED)
/*@DiscriminatorColumn(
		name="VEHICLE_TYPE",
		discriminatorType = DiscriminatorType.STRING
		)
@DiscriminatorValue("VEHICLE")*/
public class Vehicle {
	
	@Id  @GeneratedValue(strategy=GenerationType.TABLE)
	private int vehicleId;
	private String vehicleName;
	
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
