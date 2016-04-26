package part3.intermediateoperations.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

/**
 * Using “data.txt” 
 * - count the number of words
 * - print the length of each word
 * 
 * @author AOHZ
 *
 */
public class Ex4AdvancedMappingEx {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======FlapMap==========");
			printTheTotalNumberOfWords(path);

			System.out.println("=======MapToInt==========");
			printTheLengthOfEachWordUsingMapToInt(path);

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void printTheTotalNumberOfWords(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			
		}
	}

	public static void printTheLengthOfEachWordUsingMapToInt(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {			
			
		}
	};
	
}
