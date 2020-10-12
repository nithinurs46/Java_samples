package hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure().buildSessionFactory();

		HibernateTest test = new HibernateTest();

		UserDetails user = new UserDetails();
		
		Address address1 = new Address();
		address1.setCity("Mysuru");
		address1.setPincode(570004);
		address1.setState("KA");
		
		Address address2 = new Address();
		address2.setPincode(570016);
		address2.setState("AP");
		
		Address address3 = new Address();
		address3.setCity("Bengaluru");
		address3.setState("KA");
		
		/*test.addUser(1,"User1",new Date(),"summary1",address1,new Address());
		test.addUser(2,"User2",new Date(),"summary2",new Address(),address2);
		test.addUser(3,"User3",new Date(),"summary3",address3,new Address());*/
		
		//ArrayList<Address> addressList = (ArrayList<Address>) user.getListOfAddresses();
		ArrayList<Address> addressList = new ArrayList<Address>();
		addressList.add(address1);
		addressList.add(address2);
		addressList.add(address3);
		test.addUser(1,"User1",new Date(),"summary1",addressList);
		
		addressList.add(address2);
		test.addUser(2,"User2",new Date(),"summary2",addressList);
		
		addressList.add(address3);
		test.addUser(3,"User3",new Date(),"summary3",addressList);
		
		user = test.getUser(1);
		System.out.println("User obtained : "+user.getListOfAddresses().size());
		
		List usersList = new ArrayList();
		usersList = test.getUsers();

		for (Iterator iterator = usersList.iterator(); iterator.hasNext();)
		{
			UserDetails users = (UserDetails) iterator.next();
			System.out.println("USER ID : " + users.getUserID());
			System.out.println("JOINING DATE : " + users.getJoiningDate());
			System.out.println("USER NAME : " + users.getUserName());
		}
		
		user = test.updateUser(2, "updated summary");
		System.out.println("Updated User : "+user.getSummary());
		
		//user = test.deleteUser(3);
		System.out.println("Deleted User : "+user.getUserID());
		
		/*user = test.getUser(3);
		System.out.println("User obtained : "+user.getUserName());*/
		
	}
	
//	public void addUser(int userId, String userName, Date joinDate, String summary,Address homeAddress, Address officeAddress){
	public void addUser(int userId, String userName, Date joinDate, String summary, ArrayList listOfAddress){
		
		UserDetails user = new UserDetails();
		//user.setUserID(userId);
		user.setUserName(userName);
		user.setJoiningDate(joinDate);
		user.setSummary(summary);
		/*user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);*/
		user.setListOfAddresses(listOfAddress);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public UserDetails getUser(int userId){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user = new UserDetails();
		user = (UserDetails) session.get(UserDetails.class, userId);// 2nd argument takes the primary key value
		session.close();
		user.getListOfAddresses();
		return user;
	}

	public List getUsers(){
		List users = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		users = session.createQuery("From UserDetails").list();
		return users;
		
	}

	public UserDetails updateUser(int userId, String summary)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user  = new UserDetails();
		user = (UserDetails) session.get(UserDetails.class, userId);
		user.setSummary(summary);
		session.update(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	public UserDetails deleteUser(int userId){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user = (UserDetails) session.get(UserDetails.class, userId);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}
}
