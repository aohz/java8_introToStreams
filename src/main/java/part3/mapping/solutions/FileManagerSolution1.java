package part3.mapping.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

public class FileManagerSolution1 {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======FlapMap==========");
			countWordsUsingFlapMap(path);

			System.out.println("=======MapToInt==========");
			countLinesUsingMapToInt(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void countWordsUsingFlapMap(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			
			System.out.println(lines.flatMap((s) -> Stream.of(s.split(" "))).count());
		}
	}
	
	public static void countLinesUsingMapToInt(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {
			
			System.out.println(lines.peek(System.out::print).mapToInt((s)->s.split(" ").length).peek(System.out::println).sum());
		}
	};
}
