package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest implements Comparable {

	int id;

	ComparableTest(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Object o) {
		int ret = 0;
		if (this.id == ((ComparableTest) o).id) {
			ret = 0;
		}

		if (this.id <= ((ComparableTest) o).id) {
			ret = -1;
		}

		if (this.id >= ((ComparableTest) o).id) {
			ret = +1;
		}
		return ret;
	}

	public static void main(String[] args) {
		List l = new ArrayList();
		ComparableTest test = new ComparableTest(4);
		ComparableTest test1 = new ComparableTest(3);
		l.add(test);
		l.add(test1);

		Collections.sort(l);

		for (int i = 0; i < l.size(); i++) {
			System.out.println(((ComparableTest) l.get(i)).id);
		}
	}
}
