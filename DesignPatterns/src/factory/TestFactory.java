package factory;

import java.util.Scanner;

public class TestFactory {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String format = scanner.nextLine();
		ReportGenerator repGen = ReportGeneratorFactory.getReportGenerator(format);
		repGen.generateReport();
	}

}
