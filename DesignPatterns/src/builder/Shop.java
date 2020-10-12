package builder;

public class Shop {
	
	public static void main(String[] args) {

		//Builder pattern - Is used to construct a complex object step by step and the final step will return the object
		// If we are not using the builder pattern,
		// we have have created a phone obj like -
		Phone p = new Phone("Android", "2GB", "Snapdragon", "3000mah");
		System.out.println(p);
		// in above approach, we have to remember the order of parameters
		// to simplify, we can use Builder pattern as shown below
		Phone phone = new PhoneBuilder().setOS("Android").setProcessor("Snapdragon").getPhone();
		// here we can call set method to parameters we need
		System.out.println(phone);
		
	}
	

}
