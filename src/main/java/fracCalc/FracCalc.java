package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String input = "";
		input = userInput.nextLine();
		while (!input.equals("quit")) {
			System.out.print(produceAnswer(input));
			System.out.println();
			input = userInput.nextLine();
		}
		userInput.close();
	}

	public static String produceAnswer(String input) {
		char devider = 'a';
		int i = 0;
		while (devider != ' ') {
			i++;
			devider = input.charAt(i);
		}
		String input1 = input.substring(0, i);
		String operation = input.substring(i + 1, i + 2);
		String input2 = input.substring(i + 3);
		
		String lists = "whole:" + whole(input2) + " numerator:" + numerator(input2) + " denominator:" + denominator(input2);
		return lists;
	}
	
	public static int whole(String fraction) {
		int whole = 0;
		if (fraction.indexOf("/") == -1) {
			whole = Integer.parseInt(fraction);
		} else {
			if (fraction.indexOf("_") != -1) {
				whole = Integer.parseInt(fraction.substring(0, fraction.indexOf("_")));
			}
		}
		return whole;
	}
	public static int numerator(String fraction) {
		int numerator = 0;
		if (fraction.indexOf("/") != -1) {
			if (fraction.indexOf("_") != -1) {
				numerator = Integer.parseInt(fraction.substring(fraction.indexOf("_") + 1, fraction.indexOf("/")));
			} else {
				numerator = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
			}
		}
		return numerator;
	}
	public static int denominator(String fraction) {
		int denominator = 1;
		if (fraction.indexOf("/") != -1) {
			denominator = Integer.parseInt(fraction.substring(fraction.indexOf("/") + 1));
		}
		return denominator;
	}
}
