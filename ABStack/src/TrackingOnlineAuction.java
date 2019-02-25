import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrackingOnlineAuction {

	public static void main(String[] args) throws FileNotFoundException {
		
		ABStack<String> HighBidder= new ABStack<String>();
		ABStack<Integer> HighBid = new ABStack<Integer>();
		ABStack<Integer> MaxBid = new ABStack<Integer>();
		int input; 
		String name;
		int result=1;
		
		
		
		File list = new File("bids.txt");
	    Scanner fileReader = new Scanner(list);
	    
		
		System.out.println("New Bid        Result                 High Bidder     High Bid      Maximum Bid");
		System.out.println("-------------------------------------------------------------------------------");
			    
	    while (fileReader.hasNext()) {
	    	input =fileReader.nextInt();
	    	name=fileReader.next();
	    	
	    	if(HighBid.isEmpty()) {
	    		MaxBid.push(input);
	    		HighBidder.push(name);
	    		HighBid.push(1);
	    		
	    		System.out.println(input+" "+name+"        New High Bidder         "+HighBidder.peek()+
						   "               "+HighBid.peek()+"             "+MaxBid.peek());
	    	}else {
	    		if (input > HighBid.peek()) {
	    	
	    		if (input>MaxBid.peek()) {
	    			HighBid.push(MaxBid.peek()+1);
	    			MaxBid.push(input);
	    			HighBidder.push(name);
	    			result=1;
	    		}else {
	    			HighBid.push(input);
	    			HighBidder.push(HighBidder.peek());
	    			result=2;
	    		}
	    			
	    	}else
	    		result=3;
	    	switch(result) {
	    	
	    		case 1: 
	    			
	    			System.out.println(input+" "+name+"        New High Bidder         "+
	    	        HighBidder.peek()+"               "+HighBid.peek()+"          "+MaxBid.peek());
	    			break;
	    		case 2:
	    			System.out.println(input+" "+name+"        New Highest Bid         "+
	    	    	        HighBidder.peek()+"               "+HighBid.peek()+"          "+MaxBid.peek());
	    	    			break;
	    		case 3:
	    			System.out.println(input+" "+name+"        No Change               "+
	    	    	        HighBidder.peek()+"               "+HighBid.peek()+"          "+MaxBid.peek());
	    	    			break;
	    	}
	    	}
		}
	    
	    System.out.println("\nThe bid history for this auction is:");
	    
	    while(!HighBid.isEmpty() && !HighBidder.isEmpty()) {
			System.out.print(HighBidder.pop()+ "          "+ HighBid.pop());
		System.out.println();
	    }
	    fileReader.close();
	}

}
