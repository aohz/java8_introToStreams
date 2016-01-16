package part3.mapping.exercises;

import java.io.IOException;
import java.nio.file.Path;

import services.FileService;

/**
 * Using “data.txt” 
 * - count the number of words
 * - print the length of each word
 * 
 * @author AOHZ
 *
 */
public class FileManagerEx2 {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======FlapMap==========");
			countWordsUsingFlapMap(path);

			System.out.println("=======MapToInt==========");
			printTheLengthOfEachWordhUsingMapToInt(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void countWordsUsingFlapMap(Path path) throws IOException {
		
	}

	public static void printTheLengthOfEachWordhUsingMapToInt(Path path) throws IOException {
		
	};
	
}
