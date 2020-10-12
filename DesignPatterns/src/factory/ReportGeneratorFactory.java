package factory;

public class ReportGeneratorFactory {

	public static ReportGenerator getReportGenerator(String format) {
		if (format == null) {
			return null;
		}
		ReportGenerator repGen = null;
		switch (format) {
		case "PDF":
			repGen = new PdfReport();
			break;
		case "WORD":
			repGen = new WordReport();
			break;
		default:
			break;
		}
		return repGen;

	}

}
