package model.util;

import java.io.File;

import db.DbException;

public class Decisions {

	public static String awnserForFirstLayer(int x) {
		if (x <= 4) {
			if (x == 1) {
				return ReadText.readerAText(
						new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser1.txt"));
			} else if (x == 2) {
				return ReadText.readerAText(
						new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser2.txt"));
			} else if (x == 3) {
				return ReadText.readerAText(
						new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser3.txt"));
			} else {
				return "List of seller:";
			}
		} else {
			throw new DbException("Awnser is not accept: ");
		}
	}

	public static String awnserForSecondLayer(int x) {
		if (x <= 3 && x > 0) {
			if (x == 1) {
				return ReadText.readerAText(
						new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser1-1.txt"));
			} else {
				return ReadText.readerAText(
						new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser1-2.txt"));
			}
		} else {
			throw new DbException("awnser is not accept: ");
		}
	}
	
	public static String AwnserForThirdLayer(int x) {
		if (x <= 3 && x > 0) {
			if (x == 1) {
				return ReadText.readerAText(
						new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser2-1.txt"));
			} else {
				return ReadText.readerAText(
						new File("C:\\projeto-java\\Project-jdbc\\Project-DAO\\textWithOptions\\awnser2-2.txt"));
			}
		} else {
			throw new DbException("awnser is not accept: ");
		}
	
	}

}
