package com;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Utility {

	public File getFile(String fileName) throws URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("File not found..." + fileName);
		} else {
			return new File(resource.toURI());
		}
	}
}
