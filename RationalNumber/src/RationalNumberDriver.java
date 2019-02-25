import java.io.*;
import java.util.Scanner;

public class RationalNumberDriver {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int n1,d1;
		boolean secondFound = false, firstFound = false;
		RationalNumber num1= null, num2= null;
		
		File list = new File("fractions.txt");
	    Scanner fileReader = new Scanner(list);
	    
	    System.out.println("Program is reading input file to validate"
	    		           + " two rational numbers...");
	    
	    while (fileReader.hasNext() && secondFound==false) {
	    	
	    	n1= fileReader.nextInt();
	    	d1= fileReader.nextInt();
	    	
	    	if(d1==0) {
	    		System.out.println("Invalid Fraction: denominator cannot " +
	    							"be zero.");
	    	} else if(firstFound == false) {
	    		num1= new RationalNumber(n1, d1);
	    		firstFound=true;
	    		System.out.println("The first valid fraction obtained is:     " +
	    				           num1.toString() + "     " + num1.toDecimal());
	    		
	    	} else {
	    		num2= new RationalNumber(n1, d1);
	    		secondFound=true;
	    		System.out.println("The second valid fraction obtained is:     " +
				           num2.toString() + "     " + num2.toDecimal());
	    	}
	    	

		}
			
    	System.out.println("\nProgram is now performing arithmetic " +
				"operations on the two fractions...");
    	RationalNumber result = num1.addition(num2);
    	System.out.println(num1.toString() + " + " + num2.toString() +" = " +
    						result.toString() + " = " + result.toDecimal());
    	
    	result = num1.subtraction(num2);
    	System.out.println(num1.toString() + " - " + num2.toString() +" = " +
    						result.toString() + " = " + result.toDecimal());
    	
    	result = num1.multiplication(num2);
    	System.out.println(num1.toString() + " * " + num2.toString() +" = " +
    						result.toString() + " = " + result.toDecimal());
    	
    	if(num2.getNumerator() != 0) {
    	result = num1.division(num2);
    	System.out.println(num1.toString() + " / " + num2.toString() +" = " +
    						result.toString() + " = " + result.toDecimal());
    	}
    	else System.out.println("unable to conduct division of the two" 
    							+ " fractions due to numerator of second "
    							+ " fraction being zero (0).");
    	
    	System.out.println("\n Program is complete \n goodbye");
    	
    	fileReader.close();
	}

}




