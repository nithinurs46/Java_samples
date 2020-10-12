package onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		UserDetailsOneToMany user = new UserDetailsOneToMany();
		
		user.setUserName("User 1");
		
		VehicleOneToMany vehicle1 = new VehicleOneToMany();
		vehicle1.setVehicleName("CAR");
		
		VehicleOneToMany vehicle2 = new VehicleOneToMany();
		vehicle2.setVehicleName("BIKE");
		
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		
		vehicle1.setUser(user);
		vehicle2.setUser(user);
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		/*session.save(vehicle1);
		session.save(vehicle2);*/
		session.getTransaction().commit();
		session.close();
		
	}
	
}
