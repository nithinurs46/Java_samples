package inheritance.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("vehicle");
		
		TwoWheeler twoWheel = new TwoWheeler();
		twoWheel.setVehicleName("bike");
		twoWheel.setSteeringHandle("handle bar");
		
		FourWheeler fourWheel = new FourWheeler();
		fourWheel.setVehicleName("Car");
		fourWheel.setSteeringWheel("circular ring");
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(twoWheel);
		session.save(fourWheel);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
