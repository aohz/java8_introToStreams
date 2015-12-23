package part3.filtering.exercises;

import java.io.IOException;
import java.nio.file.Path;

import services.FileService;

public class FileManagerExercise {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			printLineNumber(path);
			printLineNumberUsingFiler(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printLineNumber(Path path) throws IOException {
		long nLines = 0;
		System.out.println("Lines: " + nLines);
	}

	public static void printLineNumberUsingFiler(Path path) throws IOException {
		long nLines = 0;
		System.out.println("Lines: " + nLines);
	}

}
