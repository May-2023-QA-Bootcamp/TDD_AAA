package unit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import constants.IFileLocator;
import utils.ReadFile;

public class ReadFileTest {

	@Test
	public void readTxtFileUsingBufferedReader() throws IOException {
		File fileName = new File("src/main/resources/menu.txt");
		System.out.println(fileName.exists());
		System.out.println(fileName.canExecute());
		System.out.println(fileName.canRead());
		System.out.println(fileName.canWrite());
		
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/menu.txt"));
		String lineString;
		List<String> list = new ArrayList<>();
		while((lineString = reader.readLine()) != null) {
			//System.out.println(lineString);
			list.add(lineString);
		}
		
		for(String s: list) {
			System.out.println(s);
		}
	}
	
	@Test
	public void readFileTest() {
		ReadFile readFile = new ReadFile(IFileLocator.MENU);
		System.out.println(readFile.getList());
	}
	
	//Apache POI you will able read PDF, EXCEL, DOC
}
