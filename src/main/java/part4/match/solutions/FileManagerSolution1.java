package part4.match.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

public class FileManagerSolution1 {

	/**
	 * Verify if all files lines contains the word “lazy” . Verify if any
	 * contains the word “fox” . Get the first line that contains the word cat
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		
		try {
			System.out.println("=======All==========");
			verifyAllContains(path, "lazy");

			System.out.println("=======Any==========");
			verifyAnyContains(path, "fox");
			
			System.out.println("=======Find==========");
			getFirst(path, "cat");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void verifyAllContains(Path path, String wordToFind) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			System.out.println(lines.allMatch((s) -> s.contains(wordToFind)));
		}
	}
	
	public static void verifyAnyContains(Path path, String wordToFind) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			System.out.println(lines.anyMatch((s) -> s.contains(wordToFind)));
		}
	}


	public static void getFirst(Path path, String wordToFind) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			System.out.println(lines.filter((s) -> s.contains(wordToFind)).findFirst().get());
		}
	}
}
