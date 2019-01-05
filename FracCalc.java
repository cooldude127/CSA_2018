//Rahul Amin November 19, 2018 Period:1
//FracCalc Project
//This is the final version of FracCalc, Checkpoints #1,2,3 are all commented and below
//Any use of this code should be used for reference only.
//I am not responsible for any illicit use of this code.
package fracCalc;

import java.util.Scanner;

public class FracCalc {
//Test: 1_2/3 + 4_5/6
	// Main Method
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the fraction caluclator!");
		System.out.println("Type in your fraction below or type quit to stop at anytime");
		System.out.print("Type your equation:");
		String input = console.nextLine();
		// Accepts input until quit is typed
		while (!(input.equals("quit"))) {
			System.out.println("Answer: "+produceAnswer(input));
			System.out.println();
			System.out.print("Type another equation:");
			input = console.nextLine();
		}
	}
//This is the produce answer function which calculates the fraction
	public static String produceAnswer(String input) {
		// Priming the variables
		String op1 = "";
		String op2 = "";
		String op3 = "";
		int gcd = 1;
		String wholeanswer = "";
		String numanswer = "";
		String denanswer = "";
		String whole = "0";
		String numerator = "0";
		String denominator = "1";
		String whole2 = "0";
		String numerator2 = "0";
		String denominator2 = "1";
		int sumnum = 0;
		int sumden = 0;
		// Checkpoint 1
		int x = input.indexOf(" ");
		// Calculating the operands
		op1 = input.substring(0, x);
		op2 = input.substring(x + 3);
		op3 = input.substring(x + 1, x + 2);
		// Checkpoint 2
		int a = op1.indexOf("_");
		int b = op1.indexOf("/");
		int y = op2.indexOf("_");
		int z = op2.indexOf("/");
		// Using If statements to calculate the operands for different scenarios
		// Checks for mixed number
		if (op1.contains("_") && op1.contains("/")) {
			whole = op1.substring(0, a);
			numerator = op1.substring(a + 1, b);
			denominator = op1.substring(b + 1);
		}
		// checks for fraction
		else if (!op1.contains("_") && op1.contains("/")) {
			numerator = op1.substring(0, b);
			denominator = op1.substring(b + 1);
			whole = "0";
		}
		// checks for regular whole number
		else if (!op1.contains("_") && !op1.contains("/")) {
			whole = op1;
			numerator = "0";
			denominator = "1";
		}
		// for 0
		else {
			numerator = "0";
		}
		// Samething as above except for op2
		// Checks for mixed number
		if (op2.contains("_") && op2.contains("/")) {
			whole2 = op2.substring(0, y);
			numerator2 = op2.substring(y + 1, z);
			denominator2 = op2.substring(z + 1);
		}
		// checks for fraction
		else if (!op2.contains("_") && op2.contains("/")) {
			numerator2 = op2.substring(0, z);
			denominator2 = op2.substring(z + 1);
			whole2 = "0";
		}
		// checks for regular whole number
		else if (!op2.contains("_") && !op2.contains("/")) {
			whole2 = op2;
			numerator2 = "0";
			denominator2 = "1";
		}
		// for 0
		else {
			numerator2 = "0";
		}
		//Checkpoint #3
		// Converts strings to ints
		int numeratorop1 = Integer.parseInt(numerator);
		int wholeop1 = Integer.parseInt(whole);
		int denominatorop1 = Integer.parseInt(denominator);
		int numeratorop2 = Integer.parseInt(numerator2);
		int wholeop2 = Integer.parseInt(whole2);
		int denominatorop2 = Integer.parseInt(denominator2);

		// Uses If statements to solve for negative improper fractions
		// Converts to improper fractions for op1
		if ((wholeop1 * denominatorop1) >= 0) {
			numeratorop1 = ((wholeop1 * denominatorop1) + numeratorop1);
		} else if ((wholeop1 * denominatorop1) < 0) {
			numeratorop1 = ((wholeop1 * denominatorop1) - numeratorop1);
		}
		// Converts to improper fractions for op2
		if ((wholeop2 * denominatorop2) >= 0) {
			numeratorop2 = ((wholeop2 * denominatorop2) + numeratorop2);
		} else if ((wholeop2 * denominatorop2) < 0) {
			numeratorop2 = ((wholeop2 * denominatorop2) - numeratorop2);
		}
		// Operations Begin Here
		// Calculates for addition
		if (op3.equals("+")) {
			sumnum = (numeratorop1 * denominatorop2) + (numeratorop2 * denominatorop1);
			sumden = (denominatorop1 * denominatorop2);
		}
		// Calculates for subtraction
		else if (op3.equals("-")) {
			sumnum = numeratorop1 * denominatorop2 - numeratorop2 * denominatorop1;
			sumden = (denominatorop1 * denominatorop2);
		}
		// Calculates for multiplication
		else if (op3.equals("*")) {
			sumnum = (numeratorop1 * numeratorop2);
			sumden = (denominatorop1 * denominatorop2);
		}
		// Calculates for division
		else if (op3.equals("/")) {
			sumnum = (numeratorop1 * denominatorop2);
			sumden = (denominatorop1 * numeratorop2);
		}
		wholeanswer = (sumnum / sumden) + "";
		numanswer = sumnum % sumden + "";
		denanswer = sumden + "";
		//For loop calculates the gcd of both number
		for (int i = 1; i <= Math.abs(sumden) && i <= Math.abs(sumnum); i++) {
			if (sumnum % i == 0 && sumden % i == 0)
				gcd = i;
		}
		String answer = "";
		//Calculates the reduced fraction by using gcd
		if (numanswer.equals("0")) {
			answer = wholeanswer;
		} else if (Math.abs(sumnum) > Math.abs(sumden)) {
			answer = wholeanswer + "_" + (Math.abs((sumnum % sumden) / gcd)) + "/" + Math.abs((sumden / gcd));
		} else if (Math.abs(sumden) > Math.abs(sumnum) && sumden < sumnum) {
			answer = ("-" + (sumnum % sumden) / gcd) + "/" + Math.abs((sumden / gcd));
		} else if (Math.abs(sumden) > Math.abs(sumnum)) {
			answer = ((sumnum % sumden) / gcd) + "/" + Math.abs((sumden / gcd));
		} else if (sumnum / sumden == 0) {
			answer = "0";
		}
		// answer = "numerator1: "+numeratorop1+" "+"numerator2: "+numeratorop2+"
		// "+"whole1: "+wholeop1+" "+"denominator1: "+denominatorop1+" "+"denominator2:
		// "+denominatorop2+" "+"sumnum: "+sumnum+" "+"sumden: "+sumden;
		return answer;
	}

	// Extra Stuff Ignore this
	// String secondWhole = "0";
	String secondNum = "1";

}
