package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
	public static void main(String[] args) {
		try {
			JsonParser parser = new JsonParser();

			// Json inside another Json ->
			/*
			 * {"1035":{"fontcolor":"#592902","labelfontcolor":"#F5750D","topTextFontSize":
			 * "12pt"},
			 * "1041":{"fontcolor":"#EC00FB","labelfontcolor":"#EC00FB","topTextFontSize":
			 * "7pt"},
			 * "1102":{"fontcolor":"#FF00F3","labelfontcolor":"#6EA09D","topTextFontSize":
			 * "6pt"}}
			 */

			String filePath = "C:\\work\\fontProperties.json";
			JSONObject json = parser.readJsonFile(filePath);
			parser.getJsonAndParseChild(json);
			parser.iterateAndParseEachJson(json);

			// Convert String to JSONObject and Parse Json Array
			/*
			 * {"employees":[{"firstName":"Rahul","lastName":"Dravid","pincode":"570004"},
			 * {"firstName":"Yuvraj","lastName":"Singh","pincode":"570005"}]}
			 */
			parser.parseJsonArray();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private JSONObject readJsonFile(String filePath) {
		JSONObject json = null;
		try {
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			json = new JSONObject(content);
			return json;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

	@SuppressWarnings("unchecked")
	private void getJsonAndParseChild(JSONObject jsonObj) throws JSONException {
		JSONObject subJsonObj = (JSONObject) jsonObj.get("1041");
		System.out.println("Displaying getJsonAndParseChild()--> ");
		subJsonObj.keys().forEachRemaining(key -> {
			String value = null;
			try {
				value = (String) subJsonObj.get((String) key);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			System.out.println("key: " + key + " ** value: " + value);
		});
	}

	@SuppressWarnings("unchecked")
	private void iterateAndParseEachJson(JSONObject jsonObj) throws JSONException {
		System.out.println("Displaying iterateAndParseJson()--> ");
		jsonObj.keys().forEachRemaining(key -> {
			try {
				JSONObject subJsonObj = (JSONObject) jsonObj.get((String) key);
				System.out.println("Iterating child Json");
				subJsonObj.keys().forEachRemaining(subKey -> {
					String subValue = null;
					try {
						subValue = (String) subJsonObj.get((String) subKey);
					} catch (JSONException e) {
						e.printStackTrace();
					}
					System.out.println("subKey: " + subKey + " ** subValue: " + subValue);
				});

			} catch (JSONException e) {
				e.printStackTrace();
			}

		});

	}

	@SuppressWarnings("unchecked")
	private void parseJsonArray() throws JSONException {
		String jsonArr = "{\"employees\":[{\"firstName\":\"Rahul\",\"lastName\":\"Dravid\",\"pincode\":\"570004\"},"
				+ "{\"firstName\":\"Yuvraj\",\"lastName\":\"Singh\",\"pincode\":\"570005\"}]}";
		JSONObject jsonObj = new JSONObject(jsonArr);
		JSONArray empArr = jsonObj.getJSONArray("employees");
		// iterate as an array and get value based on key
		for (int i = 0; i < empArr.length(); i++) {
			String firstName = empArr.getJSONObject(i).getString("firstName");
			System.out.println(firstName);
			String lastName = empArr.getJSONObject(i).getString("lastName");
			System.out.println(lastName);
		}

		// fetch each employee as json object and iterate them
		for (int i = 0; i < empArr.length(); i++) {
			JSONObject json = empArr.getJSONObject(i);
			json.keys().forEachRemaining(key -> {
				String value = null;
				try {
					value = (String) json.get((String) key);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("key: " + key + " ** value: " + value);
			});
		}
	}

}
