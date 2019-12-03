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
		int numerator1 = 0;
		int denominator1 = 0;
		int numerator2 = 0;
		int denominator2 = 0;
		if (whole(input1) >= 0) {
			numerator1 = numerator(input1) + (whole(input1) * denominator(input1));
			denominator1 = denominator(input1);
		}
		if (whole(input1) < 0) {
			numerator1 = -1 * (numerator(input1) - (whole(input1) * denominator(input1)));
			denominator1 = denominator(input1);
		}
		if (whole(input2) >= 0) {
			numerator2 = numerator(input2) + (whole(input2) * denominator(input2));
			denominator2 = denominator(input2);
		}
		if (whole(input2) < 0) {
			numerator2 = -1 * (numerator(input2) - (whole(input2) * denominator(input2)));
			denominator2 = denominator(input2);
		}
		String answer = "";
		if (operation.equals("+")) {
			answer = addition(numerator1, denominator1, numerator2, denominator2);
		} else if (operation.equals("-")) {
			answer = subtraction(numerator1, denominator1, numerator2, denominator2);
		} else if (operation.equals("*")) {
			answer = multipulcation(numerator1, denominator1, numerator2, denominator2);
		} else if (operation.equals("/")) {
			answer = devision(numerator1, denominator1, numerator2, denominator2);
		}
		/* int ansNum = numerator(answer);
		int ansDen = denominator(answer);
		int ansWhole = ansNum / ansDen;
		int finalNum = ansNum % ansDen;
		while ()
		for (i = ansDen; i > 1; i--) {
			if (finalNum % i == 0 && ansDen % i == 0) {
				finalNum /= i;
				ansDen /= i;
			}
		}*/
		return answer;
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

	public static String addition(int num1, int den1, int num2, int den2) {
		int newDen = den1 * den2;
		int newNum1 = num1 * den2;
		int newNum2 = num2 * den1;
		int ansNum = newNum1 + newNum2;
		String answer = ansNum + "/" + newDen;
		return answer;
	}

	public static String subtraction(int num1, int den1, int num2, int den2) {
		int newDen = den1 * den2;
		int newNum1 = num1 * den2;
		int newNum2 = num2 * den1;
		int ansNum = newNum1 - newNum2;
		String answer = ansNum + "/" + newDen;
		return answer;
	}

	public static String multipulcation(int num1, int den1, int num2, int den2) {
		int newDen = den1 * den2;
		int newNum = num1 * num2;
		String answer = newNum + "/" + newDen;
		return answer;
	}

	public static String devision(int num1, int den1, int num2, int den2) {
		int newDen = den1 * num2;
		int newNum = num1 * den2;
		String answer = newNum + "/" + newDen;
		return answer;
	}
}
