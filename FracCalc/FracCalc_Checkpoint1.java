//Rahul Amin November 19, 2018 Period:1
//FracCalc Project
//FracCalc Checkpoint #1
//Any use of this code should be used for reference only.
//I am not responsible for any illicit use of this code.

package fracCalc;

import java.util.Scanner;

public class FracCalc{

//Test: 1_2/3 + 4_5/6
    public static void main(String[] args) {
    		Scanner console = new Scanner(System.in);
    		System.out.print("Type your equation:");
    		String equation = console.nextLine();
    		System.out.println(produceAnswer(equation));
    	
    // TODO: Read the input from the user and call produceAnswer with an equation

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    	String op1 = "";
    	String op2 = "";
    	String op3 = "";
    	int x= input.indexOf(" ");
    	op1 = input.substring(1, x);
    	op2 = input.substring(x+3);
    	return op2;
    	
    
        // TODO: Implement this function to produce the solution to the input
    	
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
