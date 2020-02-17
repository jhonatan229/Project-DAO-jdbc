package model.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {
	
	public static String readerAText(File file) {
		String line = null;
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		    line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException e ) {
			System.out.println("error in readed file " + e.getMessage());
		}
		if(line == null) {
			return " ";
		}
		else {
			return line;
		}
	}
}
