package fr.insee.ocr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Ocr {
	
	public static List<BankAccountNumber> parseAll(String fileName) throws IOException {
		List<String> allDigits = new ArrayList<>();
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		for(int n = 0; n < lines.size(); n += 4) {
			String line1 = lines.get(n);
			String line2 = lines.get(n + 1);
			String line3 = lines.get(n + 2);
			allDigits.add(readDigits(line1, line2, line3));
		}
		return allDigits.stream()
			.map(BankAccountNumber::of)
			.collect(Collectors.toList());
	}
	
	public static BankAccountNumber parseOne(String fileName) throws IOException {
		return parseAll(fileName).get(0);
	}
	
	public static void printLog(String fileName) throws IOException {
		parseAll(fileName).forEach(b -> System.out.println(b.getNumber() + (b.status() == Status.OK ? "" : " " + b.status())));
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
			int digit = Digits.numberFromDigitArray(oneDigitArray);
			if(digit >= 0) {
				digits.append(digit);
			}
			else {
				digits.append("?");
			}
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
}
