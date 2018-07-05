package fr.insee.ocr;

public class Digits {

	public static final String D0 = 
		" _ " +
		"| |" +
		"|_|"
	;
	
	public static final String D1 = 
		"   " +
		"  |" +
		"  |"
	;
	
	public static final String D2 = 
		" _ " +
		" _|" +
		"|_ "
	;
	
	public static final String D3 = 
		" _ " +
		" _|" +
		" _|"
	;
	
	public static final String D4 = 
		"   " +
		"|_|" +
		"  |"
	;
	
	public static final String D5 = 
		" _ " +
		"|_ " +
		" _|"
	;
	
	public static final String D6 = 
		" _ " +
		"|_ " +
		"|_|"
	;
	
	public static final String D7 = 
		" _ " +
		"  |" +
		"  |"
	;
	
	public static final String D8 = 
		" _ " +
		"|_|" +
		"|_|"
	;
	
	public static final String D9 = 
		" _ " +
		"|_|" +
		" _|"
	;
	
	public static boolean isEqualTo(char[][] digitArray, String digitString) {
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++) {
				if(digitArray[i][j] != digitString.charAt(i + j)) {
					return false;
				}
			}			
		}
		return true;
	}
	
	public static int numberFromDigitArray(char[][] digitArray) {
		if(isEqualTo(digitArray, D0)) return 0;
		if(isEqualTo(digitArray, D1)) return 1;
		if(isEqualTo(digitArray, D2)) return 2;
		if(isEqualTo(digitArray, D3)) return 3;
		if(isEqualTo(digitArray, D4)) return 4;
		if(isEqualTo(digitArray, D5)) return 5;
		if(isEqualTo(digitArray, D6)) return 6;
		if(isEqualTo(digitArray, D7)) return 7;
		if(isEqualTo(digitArray, D8)) return 8;
		if(isEqualTo(digitArray, D9)) return 9;
		return -1;
	}
}
