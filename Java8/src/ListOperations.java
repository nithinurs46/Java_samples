import java.util.ArrayList;
import java.util.List;

public class ListOperations {

	public static void main(String[] args) {

		List<String> dataList = new ArrayList<String>();
		dataList.add("editable");
		dataList.add("readable");
		oldApproach(dataList);
		java8Approach(dataList);
	}

	private static void oldApproach(List<String> dataList) {
		List<String> tempList = new ArrayList<String>();
		if (dataList != null) {
			for (String s : dataList) {
				if (s.equals("editable")) {
					tempList.add("0");
				}

				if (s.equals("readable")) {
					tempList.add("1");
				}
			}
		}
		System.out.println("old approach templist: " + tempList);
	}

	private static void java8Approach(List<String> dataList) {
		List<String> tempList = new ArrayList<String>();

		/*if (dataList.stream().anyMatch(s -> s.equals("editable"))) {
			tempList.add("0");
		}
		if (dataList.stream().anyMatch(s -> s.equals("readable"))) {
			tempList.add("1");
		}*/

		modifyList(dataList, "editable", "0", tempList);
		modifyList(dataList, "readable", "1", tempList);
		
		// to display all the contents in list, uncomment below line
		// dataList.stream().forEach((c) -> System.out.println(c));

		System.out.println("Java 8 approach templist: " + tempList);

	}
	
	private static void modifyList(List<String> dataList, String compareValue, String newValue, List<String> tempList) {
		if (dataList.stream().anyMatch(s -> s.equals(compareValue))) {
			tempList.add(newValue);
		}
	}

}
