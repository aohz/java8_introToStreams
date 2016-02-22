package part4.match.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

/**
 * - Verify if all files lines contains the word “lazy” . 
 * - Verify if any contains the word “fox”
 * - Get the first line that contains the word cat
 * 
 * @param args
 */
public class Ex1Matching {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		
		try {
			System.out.println("=======All==========");
			verifyAllMatch(path, "lazy");

			System.out.println("=======Any==========");
			verifyAnyMatch(path, "fox");
			
			System.out.println("=======Find==========");
			getFirst(path, "cat");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void verifyAllMatch(Path path, String wordToFind) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			System.out.println("TODO: Replace with stream processing");
		}
	}
	
	public static void verifyAnyMatch(Path path, String wordToFind) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			System.out.println("TODO: Replace with stream processing");
		}
	}


	public static void getFirst(Path path, String wordToFind) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			System.out.println("TODO: Replace with stream processing");
		}
	}
}
