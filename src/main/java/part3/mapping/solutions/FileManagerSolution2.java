package part3.mapping.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import services.FileService;

public class FileManagerSolution2 {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {			
			
			printLines(path);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printLines(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			System.out.println(lines.skip(1).distinct().sorted(sortAscending())
			.flatMap(splitLinesInWords()).map(convertFirstLetterToUppercase()).collect(Collectors.joining(" ")));
			//.forEach(System.out::println);
		}
	}

	public static Comparator<String> sortAscending() {
		return String::compareTo;
	}

	public static Function<String, Stream<String>> splitLinesInWords() {
		return (String s) -> Stream.of(s.split(" "));		
	}
	
	public static Function<String, String> convertFirstLetterToUppercase() {
		return (s) -> {
			return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1).toLowerCase();
		};
	};
}
