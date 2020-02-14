package model.util;

import java.io.File;

public class Decisions {
	
	public static String awnserForFirstQestion (int x) {
		if(x == 1) {
			return ReadText.readerAText(new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser1.txt"));
		}
		else if(x == 2) {
			return ReadText.readerAText(new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser2.txt"));
		}
		else  {
			return ReadText.readerAText(new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser3.txt"));
		}
		
	}


}
