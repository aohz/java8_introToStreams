package part3.filtering.solutions;

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
public class FileManagerSolutionEx2 {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			Comparator<String> ascending = String::compareTo;
			Comparator<String> descending = ascending.reversed();
			
			System.out.println("=======Ascending==========");
			printLines(path, ascending);
			System.out.println("=======Descending==========");
			printLines(path, descending);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printLines(Path path, Comparator<String> comparator) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			lines.skip(1).distinct().sorted(comparator).forEach(System.out::println);
		}
	}
}
