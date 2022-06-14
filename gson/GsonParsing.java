package gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonParsing {
	public static void main(String[] args) {

		//convert to gson, use custom adaptor and register it
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();

		try (Reader reader = new FileReader(
				"C:\\work\\Projects\\maven-sample-proj\\src\\main\\java\\gson\\data.json")) {

			// Convert JSON File to Java Object
			Staff staff = gson.fromJson(reader, Staff.class);

			// print staff object
			System.out.println(staff);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
