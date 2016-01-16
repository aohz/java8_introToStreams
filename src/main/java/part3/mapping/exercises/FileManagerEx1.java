package part3.mapping.exercises;

import java.io.IOException;
import java.nio.file.Path;

import services.FileService;

/**
 * 
 * Using “data.txt” convert lines to Uppercase
 * 
 * @author AOHZ
 *
 */
public class FileManagerEx1 {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======To Upper Case==========");
			convertToUpperCase(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void convertToUpperCase(Path path) throws IOException {
		
	}
}
