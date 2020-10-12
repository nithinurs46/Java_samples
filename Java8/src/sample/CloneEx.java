package sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CloneEx implements Cloneable{
	
	int a; // primitive
	int b; // primitive
	Set<String> c = new HashSet<String>(Arrays.asList("one","two","three")); // mutable
	
	
	//shallow clone, uncomment this and comment deep clone method
	/*public Object clone() throws CloneNotSupportedException{
		return super.clone(); // using default implementation, shallow copy
		
	}*/
	
	//deep clone
	public Object clone() throws CloneNotSupportedException{
		CloneEx clone = (CloneEx) super.clone();
		clone.c = new HashSet<String>(); // provide ur own implementation for set
		return clone; 
		
	}
	
	public static void main(String[] args) {
		try {
			CloneEx shallow1 = new CloneEx();
			shallow1.a = 10;
			shallow1.b = 11;
			
			CloneEx shallow2 = new CloneEx();
			shallow2 = (CloneEx) shallow1.clone();
			
			System.out.println("shallow1 memory: "+shallow1+ " shallow1 values:-- a --> "+shallow1.a + ", b--> "+shallow1.b);
			System.out.println("shallow2 memory: "+shallow2+ " shallow2 values:-- a --> "+shallow2.a + ", b--> "+shallow2.b);
			
			//display hashset data
			System.out.println("shallow1 set: "+shallow1.c);
			System.out.println("shallow2 set: "+shallow2.c);
			
			System.out.println("changing shallow 1 obj data");
			
			shallow1.a = 20;
			shallow1.b = 21;
			shallow1.c.add("four");
			System.out.println("shallow1 memory: "+shallow1+ " shallow1 values:-- a --> "+shallow1.a + ", b--> "+shallow1.b);
			System.out.println("shallow2 memory: "+shallow2+ " shallow2 values:-- a --> "+shallow2.a + ", b--> "+shallow2.b);
			System.out.println("shallow1 set: "+shallow1.c);
			System.out.println("shallow2 set: "+shallow2.c);
			
			// shallow clone works fine if only primitives are copied, separate memory will be allocated for each primitive.
			// any change to primitive will not be reflected in cloned obj.
			// shallow clone doesnt work with mutable obj since the memory is shared
			// for ex, any change in hashset will be reflected in cloned obj as well
			
			
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
