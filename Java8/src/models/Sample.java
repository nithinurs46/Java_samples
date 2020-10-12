package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import com.sun.javafx.collections.MappingChange.Map;

public class Sample {
	
	public static void main(String[] args) {
		String a = "abd";
		String b = "def";
		
		char l = a.charAt(a.length()-1);
		char r = b.charAt(0);
		
		int c = Character.compare(l, r);
		System.out.println(c);
		StringBuilder sb = new StringBuilder();
		sb.toString();
		sb.length();
		
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("2");
		set.add(null);
		set.add(null);
		
		System.out.println(set.size());
		
	}
	

}
