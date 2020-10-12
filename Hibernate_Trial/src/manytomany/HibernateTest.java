package manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		UserDetailsManyToMany user = new UserDetailsManyToMany();
		
		user.setUserName("User 1");
		
		VehicleManyToMany vehicle1 = new VehicleManyToMany();
		vehicle1.setVehicleName("CAR");
		
		VehicleManyToMany vehicle2 = new VehicleManyToMany();
		vehicle2.setVehicleName("BIKE");
		
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		
		vehicle1.getUserList().add(user);
		vehicle1.getUserList().add(user);
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
