package fr.insee.ocr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Ocr {
	
	public static List<String> parseAll(String fileName) throws IOException {
		List<String> allDigits = new ArrayList<>();
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		for(int n = 0; n < lines.size(); n += 4) {
			String line1 = lines.get(n);
			String line2 = lines.get(n + 1);
			String line3 = lines.get(n + 2);
			allDigits.add(readDigits(line1, line2, line3));
		}
		return allDigits;
	}
	
	public static String parseOne(String fileName) throws IOException {
		return parseAll(fileName).get(0);
	}
	
	private static String readDigits(String line1, String line2, String line3) {
		char[][] digitsArray = new char[3][27];
		for(int n = 0; n < 27; n ++) {
			digitsArray[0][n] = line1.charAt(n);
			digitsArray[1][n] = line2.charAt(n);
			digitsArray[2][n] = line3.charAt(n);
		}
		StringBuilder digits = new StringBuilder();
		for(int index = 0; index < 9; index ++) {
			char[][] oneDigitArray = digitArrayAtIndex(digitsArray, index);
			int digit = numberAtIndex(oneDigitArray);
			digits.append(digit);
		}
		return digits.toString();
	}

	private static char[][] digitArrayAtIndex(char[][] digitsArray, int index) {
		char[][] oneDigitArray = new char[3][3];
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j ++) {
				oneDigitArray[i][j] = digitsArray[i][j + 3 * index];
			}	
		}
		return oneDigitArray;
	}

	private static int numberOfNonEmptyChars(char[][] oneDigitArray) {
		int n = 0;
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j ++) {
				if(oneDigitArray[i][j] != ' ') {
					n ++;
				}
			}			
		}
		return n;
	}
	
	private static int numberAtIndex(char[][] oneDigitArray) {
		switch(numberOfNonEmptyChars(oneDigitArray)) {
			case 7:
				return 8;
			case 6:
				if(oneDigitArray[1][1] == ' ') return 0;
				if(oneDigitArray[2][0] == ' ') return 9;
				return 6;
			case 5:
				if(oneDigitArray[1][2] == ' ') return 5;
				if(oneDigitArray[2][2] == ' ') return 2;
				return 3;
			case 4:
				return 4;
			case 3:
				return 7;
			case 2:
				return 1;
		}
		return -1;
	}
}
