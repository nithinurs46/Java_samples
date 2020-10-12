package hql;

import hibernate.UserDetails;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		//use below code to create session factory in hibernate 4.3.0 and above version	
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Query query = session.createQuery("from UserDetailsHQL");
		/*Query query = session.createQuery("select userName from UserDetailsHQL");
		query.setFirstResult(2);
		query.setMaxResults(5);
		//List<UserDetailsHQL> list = (List<UserDetailsHQL>)query.list();
		List<String> list = (List<String>)query.list();
		System.out.println("size: "+list.size());
		session.getTransaction().commit();
		session.close();
		
		for(String s:list){
			System.out.println("USers: "+s);
		}*/
		
		//userName and userID are declared in UserDetailsHQL class
		Query query = session.createQuery("select userName, userID from UserDetailsHQL");
		query.setFirstResult(2);
		query.setMaxResults(5);
		List<Object[]> users = (List<Object[]>)query.list();
		for(Object[] user: users){
	         String name = (String)user[0];
	         Integer id = (Integer)user[1];
	         System.out.println("User ID: "+id+" User Name: "+name);
	     }
		
	}
}
