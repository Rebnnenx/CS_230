import java.util.Scanner;


public class PalindromincDates {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String cont = "y";
		String year, month="", day="";
		int y=0,m,d;
		boolean imp=false, found= false, valid=false;
		
		do {
			year=month=day="";
			valid=false;
			System.out.println("please enter a four digit year:");
			year= kb.next();
			try {
				y= Integer.parseInt(year);
			}
			catch(Exception e) {
				imp= true;
			}
			
			while(year.length()!= 4 || imp) {
				System.out.println("There is an error with your year.\nPlease enter a four digit year:");
				year= kb.next();
				imp=false;
				try {
					y= Integer.parseInt(year);
				}
				catch(Exception e) {
					imp= true;
				}
			}
			month = month +year.charAt(3)+ year.charAt(2);
			m=Integer.parseInt(month);
			
			day = day +year.charAt(1)+ year.charAt(0);
			d=Integer.parseInt(day);
			
			valid =checkPal(year);
			if(valid) 
				System.out.println(month+day+year+" is a valid palindromic date");
			else
				System.out.println(month+day+year+" is not a valid palindromic date");

						
			System.out.println("Would you like to try another year?");
			cont=kb.next();
			
		
		}while(cont.equals("y")|| cont.equals("Y"));
		
		System.out.println("Would you like to know what the first palindromic date in the 21st century is?");
		cont=kb.next();
		
		if(cont.equals("y")||cont.equals("Y")) {
			LQueue<Integer> years = new LQueue<Integer>();
			for(int i=2000; i<3000;i++) {
				years.enqueue(i);
			}	
			while(!found) {
				year=month=day="";
				year=Integer.toString(years.dequeue());
				month = month +year.charAt(3)+ year.charAt(2);
				
				day = day +year.charAt(1)+ year.charAt(0);
				
				found=checkPal(year);
			}
			System.out.println("\nThe first palindromic date of the century is: "+month+day+year);
		
		}
		kb.close();
	}
	
	
	
	
	
	public static boolean checkLeapYear(int year) {
		boolean flag = false;
		
		if(year % 400 == 0)
            flag = true;
        else if (year % 100 == 0)
            flag = false;
        else if(year % 4 == 0)
            flag = true;
        else
            flag = false;
		
		return flag;
		
	}
	public static  boolean checkPal(String year) {
		int y,m,d;
		boolean valid=false;
		String month, day;
		month="";
		day="";
		
		
		month = month +year.charAt(3)+ year.charAt(2);
		m=Integer.parseInt(month);
		
		day = day +year.charAt(1)+ year.charAt(0);
		d=Integer.parseInt(day);
		
		y=Integer.parseInt(year);
		
		switch(m){
			
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (d<=31)
				valid=true;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (d<=30)
				valid=true;
			break;
			
		case 2:
			if(checkLeapYear(y)) {
				if (d<=29)
					valid=true;
				break;
			}else {
				if (d<=28)
					valid=true;
				break;
			}
		}
		return valid;
	}
}
