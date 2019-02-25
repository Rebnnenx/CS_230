import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class PreferredCustomerDriver {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File list = new File("customers.txt");
	    Scanner fileReader = new Scanner(list);
	    String input;
	    String[] inputArray= new String[6];
	    String[] name= new String[2];
	    ArrayList <PreferredCustomer> customers= new ArrayList<>();
	    
	    while(fileReader.hasNextLine()) {
	    	
	    	input=fileReader.nextLine();
	    	
	    	inputArray= input.split("; ");
	    	
	    	name= inputArray[0].split(" ");
	    	
	    	customers.add(new PreferredCustomer(name[0],name[1],inputArray[1],
	    			      inputArray[2],inputArray[3],
	    			      Boolean.parseBoolean(inputArray[4]),
	    			      Double.parseDouble(inputArray[5])));
	    }
	    
	    System.out.println("Customer Name       Customer's Discount Level"+
	    					"       Customer's Number");
	    System.out.println("=============       ========================="+
	    					"       =================");
	    
	    for(int i = 0; i <customers.size();i++ ) {
	    	
	    	 System.out.println(customers.get(i).getName()+"          "+
	    			 			customers.get(i).getDiscount() +
	    			 			"                             "+
	    			 			customers.get(i).getCustNum());
	    }
	    
	    System.out.println("\nMailing List:\n");
	    
	    for(int i=0; i<customers.size();i++) {
	    	
	    	if(customers.get(i).getMailList())
	    	System.out.println(customers.get(i).getName()+
	    			           "\n"+customers.get(i).getAddress(0)+"\n");
	    }
	    
	    System.out.println("Phone List:\n");
	    
	    for(int i=0; i<customers.size();i++) {
	    	
	    	if(customers.get(i).getMailList())
		    	System.out.println(customers.get(i).getName()+
		    			           "\n"+customers.get(i).getpNumber()+"\n");
	    }
	    
	    System.out.println("Program is done. \nGoodbye!");
	    
		fileReader.close();
	}


}
