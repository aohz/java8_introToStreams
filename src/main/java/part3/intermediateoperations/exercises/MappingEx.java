package part3.intermediateoperations.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

/**
 * 
 * Using “data.txt” convert lines to Uppercase
 * 
 * @author AOHZ
 *
 */
public class MappingEx {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======To Upper Case==========");
			convertToUpperCase(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void convertToUpperCase(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {

			
		}
	}
}
