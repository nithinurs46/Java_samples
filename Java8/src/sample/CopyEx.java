package sample;

public class CopyEx {
	
	int a;
	int b;
	
	public static void main(String[] args) {
		CopyEx shallow1 = new CopyEx();
		shallow1.a = 10;
		shallow1.b = 11;
		
		CopyEx shallow2 = new CopyEx();
		
		shallow2 = shallow1; // shallow copy
		
		System.out.println("shallow1 memory: "+shallow1+ " shallow1 values:-- a --> "+shallow1.a + ", b--> "+shallow1.b);
		System.out.println("shallow2 memory: "+shallow2+ " shallow2 values:-- a --> "+shallow2.a + ", b--> "+shallow2.b);
		// shallow copy creates a copy of object pointing to same memory location.
		//observe sysout.. both the sysout will be same.
		
		System.out.println("changing shallow 1 obj data");
		
		// any change to shallow1 will be reflected in shallow12 as well
		shallow1.a = 20;
		shallow1.b = 21;
		System.out.println("shallow1 memory: "+shallow1+ " shallow1 values:-- a --> "+shallow1.a + ", b--> "+shallow1.b);
		System.out.println("shallow2 memory: "+shallow2+ " shallow2 values:-- a --> "+shallow2.a + ", b--> "+shallow2.b);
		
		/////////////////////////////////////////////////////////
		//deep copy
		// in deep copy, all the fields needs to be copied separately. 
		
		CopyEx deep1 = new CopyEx();
		deep1.a = 30;
		deep1.b = 31;
		
		CopyEx deep2 = new CopyEx();
		deep2.a = deep1.a;
		deep2.b = deep2.b;
		
		System.out.println("deep1 memory: "+deep1+ " deep1 values:-- a --> "+deep1.a + ", b--> "+deep1.b);
		System.out.println("deep2 memory: "+deep2+ " deep2 values:-- a --> "+deep2.a + ", b--> "+deep2.b);
		
		//deep1 and deep2 will have 2 different memory location, any change to deep1 will not reflected in deep2
		System.out.println("changing state of deep1 obj");
		
		deep1.a = 40;
		deep1.b = 41;
		
		System.out.println("deep1 memory: "+deep1+ " deep1 values:-- a --> "+deep1.a + ", b--> "+deep1.b);
		System.out.println("deep2 memory: "+deep2+ " deep2 values:-- a --> "+deep2.a + ", b--> "+deep2.b);
		
		
		
	}

}
