package part3.intermediateoperations.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

/**
 * print the total number of lines in “data.txt” excluding the header and duplicate lines 
 * 
 * @author aohz
 *
 */
public class Ex1Filtering {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			printLineNumber(path);	
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void printLineNumber(Path path) throws IOException {
		int nLines = 0;
		try (Stream<String> lines = Files.lines(path);) {
			lines.count();
			
		}
		System.out.println("Lines: " + nLines);
	}
}
