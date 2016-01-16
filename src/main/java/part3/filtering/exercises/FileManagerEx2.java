package part3.filtering.exercises;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;

import services.FileService;

/**
 * 
 * Sort and print “data.txt” lines using: - Ascending order - Descending order
 * 
 * @author AOHZ
 *
 */
public class FileManagerEx2 {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			printLines(path, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printLines(Path path, Comparator<String> comparator) throws IOException {

	}
}
