package part3.intermediateoperations.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

/**
 * Count the number of lines in “data.txt” excluding the header and duplicate lines 
 * 
 * @author aohz
 *
 */
public class SolEx1Filtering {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			printLineNumber(path);
			printLineNumberUsingFilter(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printLineNumber(Path path) throws IOException {
		long nLines = 0;
		try (Stream<String> lines = Files.lines(path);) {
			nLines = lines.skip(1).distinct().count();
		}
		System.out.println("Lines: " + nLines);
	}

	public static void printLineNumberUsingFilter(Path path) throws IOException {
		long nLines = 0;
		try (Stream<String> lines = Files.lines(path);) {
			nLines = lines.filter((s) -> !s.startsWith("==")).distinct().count();
		}
		System.out.println("Lines: " + nLines);
	}

}
