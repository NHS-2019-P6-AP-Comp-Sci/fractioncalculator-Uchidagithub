package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner UserInput = new Scanner(System.in);
		String input = UserInput.nextLine();
		System.out.println(produceAnswer(input));
		UserInput.close();
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
		return input2;
	}
}
