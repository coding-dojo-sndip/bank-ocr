package fr.insee.ocr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Ocr {

	public static String parse(String fileName) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		for(int n = 0; n < lines.size(); n += 4) {
			String line1 = lines.get(n);
			String line2 = lines.get(n + 1);
			String line3 = lines.get(n + 2);
			readDigits(line1, line2, line3);
		}
		return null;
	}

	private static void readDigits(String line1, String line2, String line3) {
		int width = maxLength(line1, line2, line3);
		char[][] array = new char[3][width];
	}

	private static int maxLength(String... lines) {
		return Arrays.stream(lines)
			.mapToInt(String::length)
			.max()
			.getAsInt();
	}
}
