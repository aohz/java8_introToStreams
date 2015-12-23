package services;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import part2.generators.Sample2_Generator;

public interface FileService {

	public static final String DEFAULT_TEST_FILE = "data.txt";

	public static Path getFilePath() {
		return getFilePath(DEFAULT_TEST_FILE);
	}

	public static Path getFilePath(String fileName) {
		try {
			return Paths.get(Sample2_Generator.class.getClassLoader().getResource(fileName).toURI());
		} catch (URISyntaxException ex) {
			return null;
		}
	}
}
