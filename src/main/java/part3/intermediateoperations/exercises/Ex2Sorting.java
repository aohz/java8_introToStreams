package part3.intermediateoperations.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

import services.FileService;

/**
 * 
 * Sort and print “data.txt” lines using: 
 * - Ascending order 
 * - Descending order
 * 
 * @author AOHZ
 *
 */
public class Ex2Sorting {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			printLines(path, null);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void printLines(Path path, Comparator<String> comparator) throws IOException {
		int nLines = 0;
		try (Stream<String> lines = Files.lines(path);) {
			
		}
		System.out.println("Lines: " + nLines);
	}
}
