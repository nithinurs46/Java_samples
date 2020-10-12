package com.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test implements Itest, Itest1{

	@Override
	public void show() {
		System.out.println("Show");
	}
	
	public static void main(String[] args) {
		Itest1 obj = new Test();
		obj.show();
		
		Test test = new Test();
		
		//qn 3
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		test.operate(a, b);
		System.out.println(a+" "+", "+b);
		
		//qn 6
		test.get(10);
		test.get(1.1);
		
		//qn 22
		test.incrementTest();
		
		//qn 25
		test.integerTest();
		
		//qn 26. 27
		test.twoSeven();
		
		//qn 32
		test.threeTwo();
		
		//qn 39
		int ii=20;
		int jj=40;
		
		test.threeNine(ii, jj);
		System.out.println("ii:- "+ii +" " +"jj:- "+jj);
		
		//qn 43
		String str = "xyz";
		System.out.println("qn 43: "+str.equals(new Student()));
		
		//qn 44
		String str1 = "Manish";
		String str2 = "ManishKumar";
		System.out.println("qn 44: "+str1.compareTo(str2));
		
		//qn 45
		System.out.println('a' + "a");
		
		//qn 47
		test.fourSeven();
		
		//qn 50
		test.fifty();

	}

	public void operate(StringBuffer x, StringBuffer y) {
		x.append(y);
		y = x.append("C");
		y.append("D");
		
	}
	
	void get(long a) {
		System.out.println("inside long");
	}
	
	void get(double a) {
		System.out.println("inside double");
	}
	
	public void incrementTest() {
		int i=10;
		boolean b = (i++>10) && (++i<15);
		System.out.println(b);
		System.out.println("incrementTest: "+i);
	}
	
	public void integerTest() {
		Integer i = 127;
		Integer j = 127;
		if(i!=j) {
			System.out.println("not equal");
		} else {
			System.out.println("equal");
		}
	}
	
	public void twoSeven() {
		//qn 26
		/*while(true) {
			System.out.println("running in loop");
		}
		System.out.println("done"); // nothing can be present after while(true) .. syso allowed if while(bool).. compilation error*/
				
		// qn 27
		int i = 0;
		while (true) {
			if (i++ == 4) {
				break;
			}
			++i;
		}
		System.out.println("qn 27: " + (i++));
	}
	
	public void threeTwo() {
		List l = new ArrayList();
		for(int i=0;i<1;i++) { //Integer.MAX_VALUE
			l.add(0);
			l.add(0);
			l.add(1);
			System.out.println("qn 32: "+l.size());
		}
	}
	
	public void threeNine(int i, int j) {
		i*=2;
		j/=2;
	}
	
	private void fourSeven() {
		String str1 = "XYZ";
		String str2 = new String("XYZ");
		System.out.println("47 start");
		System.out.println(str1 == str2);
		str2.intern();
		System.out.println(str1 == str2);
		System.out.println("47 end");
	}
	
	private void fifty() {
		List l = new ArrayList();
		l.add(20);
		l.add(8);
		l.add(5);
		Collections.sort(l);
		System.out.println("50th qn");
		l.forEach(System.out::println);
	}
	
}

class Student{
	
}
