package sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date currDate=format.parse("2019-09-30");  
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		String strCurrDate = dateFormat.format(currDate);
		System.out.println("strCurrDate->"+strCurrDate);
	}

}
