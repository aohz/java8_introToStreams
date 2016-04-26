package part3.intermediateoperations.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

/**
 * 
 * Using “data.txt” 
 * - convert lines to Uppercase
 * - Print the length of each line
 * 
 * @author AOHZ
 *
 */
public class Ex3Mapping {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======To Upper Case==========");
			convertToUpperCase(path);
			System.out.println("=======Print the length of each line==========");
			printTheLengthOfEachLine(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void convertToUpperCase(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			
		}
	}
	
	public static void printTheLengthOfEachLine(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			
		}
	}
}
