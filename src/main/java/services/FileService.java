package services;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileService {

	public static final String DEFAULT_TEST_FILE = "data.txt";

	public static Path getFilePath() {
		return getFilePath(DEFAULT_TEST_FILE);
	}

	public static Path getFilePath(String fileName) {
		try {
			return Paths.get(FileService.class.getClassLoader().getResource(fileName).toURI());
		} catch (URISyntaxException ex) {
			return null;
		}
	}
}
