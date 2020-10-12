package onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		UserDetailsOneToOne user = new UserDetailsOneToOne();
		
		user.setUserName("User 1");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("CAR");
		
		user.setVehicle(vehicle);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
