//Rahul Amin November 19, 2018 Period:1
//FracCalc Project
//FracCalc Checkpoint #3
//Any use of this code should be used for reference only.
//I am not responsible for any illicit use of this code.

package fracCalc;

import java.util.Scanner;

public class FracCalc {

//Test: 1_2/3 + 4_5/6
	//Main Method
    public static void main(String[] args) 
    {
    	
    		Scanner console = new Scanner(System.in);
    		System.out.print("Type your equation:");
    		String input = console.nextLine();
    		//Accepts input until quit is typed
    		while(!(input.equals("quit"))) {
    			System.out.println(produceAnswer(input));
    			System.out.println();
    			System.out.print("Type your equation:");
    			input = console.nextLine();
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
    	String whole = "0";
    	String numerator = "0";
    	String denominator = "1";
    	String whole2 = "0";
    	String numerator2 = "0";
    	String denominator2 = "1";
    	int operand1 = 0;
    	int operand2 = 0;
    	String sum = "";
    	String difference = "";
    	String product = "";
    	String quotient = "";
    	int sumnum = 0;
    	int sumden = 0;
    	//Checkpoint 1
    	int x= input.indexOf(" ");
    	//Calculating the operands
    	op1 = input.substring(0, x);
    	op2 = input.substring(x+3);
    	op3 = input.substring(x+1,x+2);
    	//Checkpoint 3
    	int a = op1.indexOf("_");
    	int b = op1.indexOf("/");
    	int y = op2.indexOf("_");
    	int z = op2.indexOf("/");
    	//Using If statements to calculate the operands for different scenarios
    	//Checks for mixed number
    	if (op1.contains("_")&&op1.contains("/")) {
    		whole = op1.substring(0,a);
    		numerator = op1.substring(a+1,b);
    		denominator = op1.substring(b+1);
    	}
    	//checks for fraction
    	else if (!op1.contains("_")&&op1.contains("/")) {
    		numerator = op1.substring(0,b);
    		denominator = op1.substring(b+1);
    		whole = "0";
    	}
    	//checks for regular whole number
    	else if (!op1.contains("_") && !op1.contains("/")) {
    		whole = op1;
    		numerator = "0";
    		denominator = "1";
    	}
    	//for 0
    	else {
    		numerator = "0";
    	}
    	//Samething as above except for op2
    	//Checks for mixed number
    	if (op2.contains("_")&&op2.contains("/")) {
    		whole2 = op2.substring(0,y);
    		numerator2 = op2.substring(y+1,z);
    		denominator2 = op2.substring(z+1);
    	}
    	//checks for fraction
    	else if (!op2.contains("_")&&op2.contains("/")) {
    		numerator2 = op2.substring(0,z);
    		denominator2 = op2.substring(z+1);
    		whole2 = "0";
    	}
    	//checks for regular whole number
    	else if (!op2.contains("_") && !op2.contains("/")) {
    		whole2 = op2;
    		numerator2 = "0";
    		denominator2 = "1";
    	}
    	//for 0
    	else {
    		numerator2 = "0";
    	}
    	//Converts strings to ints
    	int numeratorop1 = Integer.parseInt(numerator);
    	int wholeop1 = Integer.parseInt(whole);
    	int denominatorop1 = Integer.parseInt(denominator);
    	int numeratorop2 = Integer.parseInt(numerator2);
    	int wholeop2 = Integer.parseInt(whole2);
    	int denominatorop2 = Integer.parseInt(denominator2);
    	
    	//Uses If statements to solve for negative improper fractions
    	//Converts to improper fractions for op1
    	if ((wholeop1*denominatorop1)>=0) {
    		numeratorop1 = ((wholeop1*denominatorop1)+numeratorop1);
    	}else if ((wholeop1*denominatorop1)<0) {
    		numeratorop1 = ((wholeop1*denominatorop1)-numeratorop1);
    	}
    	//Converts to improper fractions for op2
    	if ((wholeop2*denominatorop2)>=0) {
    		 numeratorop2 = ((wholeop2*denominatorop2)+numeratorop2);
    	}else if ((wholeop2*denominatorop2)<0) {
    		numeratorop2 = ((wholeop2*denominatorop2)-numeratorop2);
    	}
    	
    	 
    	 
    	//Operations Begin Here
    	//Calculates for addition
    	if (op3.equals("+")) {
    		sumnum = (numeratorop1*denominatorop2) + (numeratorop2*denominatorop1);
    		sumden = (denominatorop1*denominatorop2);
    		/*if(op1.contains("-") && op2.contains("-")) {
    			sum = sumnum +"/"+ sumden;
    		}else if(!op1.contains("-") && !op2.contains("-")) {
    			sum = sumnum +"/"+ sumden;
    		}else {
    			sum = "-"+sumnum +"/"+ sumden;
    		}
    		return sum;
    		*/
    	}
    	//Calculates for subtraction
    	else if(op3.equals("-")) {
    		sumnum = numeratorop1*denominatorop2 - numeratorop2*denominatorop1;
    		sumden = (denominatorop1*denominatorop2);
    		/*if(op1.contains("-") && op2.contains("-")) {
    			difference = sumnum +"/"+ sumden;
    		}else if(!op1.contains("-") && !op2.contains("-")) {
    			difference = sumnum +"/"+ sumden;
    		}else {
    			difference = "-"+sumnum +"/"+ sumden;
    		}
    		return difference;
    		*/
    	}
    	//Calculates for multiplication
    	else if(op3.equals("*")) {
    		sumnum = (numeratorop1*numeratorop2);
    		sumden = (denominatorop1*denominatorop2);
    		/*if(op1.contains("-") && op2.contains("-")) {
    			product = sumnum+"/"+sumden;
    		}else if(!op1.contains("-") && !op2.contains("-")) {
    			product = sumnum+"/"+sumden;
    		}else {
    			product = "-"+sumnum+"/"+sumden;
    		}
    		return product;*/
    	}
    	//Calculates for division
    	else if(op3.equals("/")) {
    		sumnum = (numeratorop1*denominatorop2);
    		sumden = (denominatorop1*numeratorop2);
    	}
    	String answer = sumnum+"/"+sumden;	
    	//String answer = numeratorop1+" "+numeratorop2+" "+wholeop1+" "+denominatorop1+" "+numeratorop1;
        return answer;
        
    	
    }	
    //Extra Stuff Ignore this
    //String secondWhole = "0";
    String secondNum = "1";
   // String second
        // TODO: Implement this function to produce the solution to the input
    
    

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
