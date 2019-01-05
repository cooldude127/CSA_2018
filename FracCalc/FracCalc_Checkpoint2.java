//Rahul Amin November 19, 2018 Period:1
//FracCalc Project
//FracCalc Checkpoint #2
//Any use of this code should be used for reference only.
//I am not responsible for any illicit use of this code.

package fracCalc;

import java.util.Scanner;

public class FracCalc{

//Test: 1_2/3 + 4_5/6
	//Main Method
    public static void main(String[] args) 
    {
    		Scanner console = new Scanner(System.in);
    		String equation = console.nextLine();
    		//Accepts input until quit is typed
    		while(!equation.equals("quit")) {
    			System.out.print("Type your equation:");
    			System.out.println(produceAnswer(equation));
    		}
    		
    	 	
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
    	//Priming the variables
    	String op1 = "";
    	String op2 = "";
    	String op3 = "";
    	String whole = "";
    	String numerator = "";
    	String denominator = "";
    	//Checkpoint 1
    	int x= input.indexOf(" ");
    	//Calculating the operands
    	op1 = input.substring(1, x);
    	op2 = input.substring(x+3);
    	op3 = input.substring(x+1,x+2);
    	//Checkpoint 3
    	int y = op2.indexOf("_");
    	int z = op2.indexOf("/");
    	//Using If statments to calculate the operands for different scenarios
    	if (op2.contains("_")&&op2.contains("/")) {
    		whole = op2.substring(0,y);
    		numerator = op2.substring(y+1,z);
    		denominator = op2.substring(z+1);
    	}else if (!op2.contains("_")&&op2.contains("/")) {
    		numerator = op2.substring(0,z);
    		denominator = op2.substring(z+1);
    		whole = "0";
    	}else if (!op2.contains("_") && !op2.contains("/")) {
    		whole = op2;
    		numerator = "0";
    		denominator = "1";
    	}else {
    		numerator = "0";
    	}
    	return ("whole:"+whole+" numerator:"+numerator+" denominator:"+denominator);
    }	
    //Extra Stuff Ignore this
    //String secondWhole = "0";
    String secondNum = "1";
   // String second
        // TODO: Implement this function to produce the solution to the input
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
