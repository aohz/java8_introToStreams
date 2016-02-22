package part3.intermediateoperations.solutions;

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
public class SolEx3Mapping {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======To Upper Case==========");
			convertToUpperCase(path);
			System.out.println("=======Print the length of each line==========");
			printTheLengthOfEachLine(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void convertToUpperCase(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			lines.map(String::toUpperCase).forEach((s) -> System.out.println(s));
		}
	}
	
	public static void printTheLengthOfEachLine(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			lines.map(String::length).forEach((s) -> System.out.println(s));
		}
	}
}
