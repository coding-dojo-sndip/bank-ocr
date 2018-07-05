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
	
	public static boolean areSame(char[][] digitArray, String digitString) {
		for (int index = 0; index < 9; index ++) {
			if(digitArray[index / 3][index % 3] != digitString.charAt(index)) {
				return false;
			}			
		}
		return true;
	}
	
	public static int numberFromDigitArray(char[][] digitArray) {
		if(areSame(digitArray, D0)) return 0;
		if(areSame(digitArray, D1)) return 1;
		if(areSame(digitArray, D2)) return 2;
		if(areSame(digitArray, D3)) return 3;
		if(areSame(digitArray, D4)) return 4;
		if(areSame(digitArray, D5)) return 5;
		if(areSame(digitArray, D6)) return 6;
		if(areSame(digitArray, D7)) return 7;
		if(areSame(digitArray, D8)) return 8;
		if(areSame(digitArray, D9)) return 9;
		return -1;
	}
}
