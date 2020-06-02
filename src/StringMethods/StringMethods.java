package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		}
		return s2;
	}

	// if String s contains the word "underscores", change all of the spaces to
	// underscores
	public static String formatSpaces(String s) {
		String newS = s.replace(" ", "_");
		if (s.contains("underscores")) {
			return newS;
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they were
	// in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String trimmed1 = s1.trim();
		String trimmed2 = s2.trim();
		String trimmed3 = s3.trim();
		String lowest;
		if (trimmed1.charAt(trimmed1.length() - 1) < trimmed2.charAt(trimmed2.length() - 1)) {
			lowest = trimmed1;
		} else {
			lowest = trimmed2;
		}
		if (trimmed1.charAt(trimmed1.length() - 1) < trimmed3.charAt(trimmed3.length() - 1)) {
			lowest = trimmed1;
		} else {
			lowest = trimmed3;
		}
		if (trimmed2.charAt(trimmed2.length() - 1) < trimmed3.charAt(trimmed3.length() - 1)) {
			lowest = trimmed2;
		} else {
			lowest = trimmed3;
		}
		return lowest;

	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int newnum = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {

				// int num = Integer.parseInt(s.charAt(i));
				newnum += Character.getNumericValue(s.charAt(i));
			}
		}
		if (s.length() == 0) {
			return 0;
		}
		return newnum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int start = 0;
		int contain = 0;
		while (s.indexOf(substring, start) >= 0) {
			contain++;
			start = s.indexOf(substring, start) + 1;

		}

		return contain;
	}

	// Call Utilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {

		return Utilities.encrypt(s.getBytes(), (byte) key);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {

		return Utilities.decrypt(s, (byte) key);
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int endsWith = 0;
		int start = 0;
		String[] newS = s.split(" ");

		for (int i = 0; i < newS.length; i++) {

			if (newS[i].endsWith(substring)) {
				endsWith++;
			}
		}

		return endsWith;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return s.lastIndexOf(substring) - (s.indexOf(substring) + substring.length());
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {

		String s1 = "";
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.toLowerCase(s.charAt(i))>=97 && Character.toLowerCase(s.charAt(i))<=122) {
				s1 += Character.toLowerCase(s.charAt(i));
				
			}
		}
		System.out.println(s1);
		for (int i = 0; i < (s1.length()/2); i++) {
			if (s1.charAt(i) != s1.charAt(s1.length() - 1 - i)) {
				return false;
			}
		}
		System.out.println(s1);
		return true;
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
