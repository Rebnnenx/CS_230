import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddressBook<T extends Comparable<T>>{
	
	public static void main(String[] args) throws IOException {
		
		LinkedList<Address> book= new LinkedList<Address>();
		boolean found=true, exit = false, changes=false;
		Scanner kb= new Scanner(System.in);
		String option;
		String ln, confirm=null;
		String[] line;
		File ab = new File("addresses.txt");
	    Scanner fr = new Scanner(ab);
		
		if(found) {
			
			//creates a linked list of the file
			while(fr.hasNextLine()) {
				Address newAddress=new Address();
				ln=fr.nextLine();
				line=ln.split(" ");
				newAddress.setFname(line[0]);
				newAddress.setLname(line[1]);
				
				ln=fr.nextLine();
				newAddress.setStreet(ln);
				
				ln=fr.nextLine();
				line=ln.split(" ");
				newAddress.setCity(line[0].substring(0, line[0].length()-1));
				newAddress.setState(line[1]);
				newAddress.setZip(line[2]);
				
				ln=fr.nextLine();
				newAddress.setCountry(ln);
				
				ln=fr.nextLine();
				newAddress.setPhone(ln);
				book.insertAtBack(newAddress);
				if(fr.hasNextLine())
					fr.nextLine();
			}
			//creates a copy of the file
			LinkedList<Address> original=new LinkedList<Address>();
			int s= book.size();
			for(int i=0; i<s; i++) {
				Address temp= book.removeFromFront();
				original.insertAtBack(temp);
				book.insertAtBack(temp);
			}
			do {
				
				System.out.println("Thank you for using this random Address Book manager.\nThese are the availabe operations."
								+ "\nSelect one by inputting the desired number:\n");
				System.out.println("1.Add a new address record\n"
						+ "2.View an existing address record\n"
						+ "3.Delete an existing address record\n"
						+ "4.Modify an existing address record\n"
						+ "5.Save the entire address book in a file\n"
						+ "6.Retrieve all address entries using zip code\n"
						+ "7.Print the entire address book on the screen\n"
						+ "0.Exit the program");
				option= kb.next();
				
				clear();
				kb.nextLine();
				
				switch(option) {
				
					case "1":{
						addRecord(book, kb);
						changes=true;
						break;
					}
					case "2":{
						viewRecord(book,kb);
						break;
					}
					
					case "3":{
						deleteRecord(book,kb);
						changes=true;
						break;
					}
					case "4":{
						modifyRecord(book,kb);
						changes=true;
						break;
					}
					case "5":{
						changes = false;
						saveFile(book);
						System.out.println("File was saved.");
						break;
					}
					case "6":
						retrieveByZip(book, kb);
						break;
					case "7":
						printAddressBook(book);
						break;
					case "0":{
						exit= true;
						if(changes) {
							do {
								clear();
								System.out.println("There are unsaved changes. Save? Y/N");
								confirm= kb.nextLine().toUpperCase();
								switch(confirm){
								
									case "Y":
										saveFile(book);
										System.out.println("File was saved.");
										break;
									case "N":
										saveFile(original);
										System.out.println("File was not saved.");
										confirm="Y";
										break;
									default:
										System.out.println("incorrect input\n");
										
								}
							}while(!confirm.equals("Y"));
							System.out.println("Goodbye");
						}
						break;
					}
					default:{
						System.out.println("Incorrect Input. Options will be redisplayed");
						pause();
					}
				
				}
				clear();
			}while(!exit);
		}
		kb.close();
		fr.close();
	}
	
	private static void saveFile(LinkedList<Address> book) {
		int size=book.size();
			try {
				FileWriter fw = new FileWriter(new File("AddressBook.txt"));
				for(int i=0;i<size;i++) {
					Address temp=book.removeFromFront();
					book.insertAtBack(temp);
					fw.write(temp.toString()+"\n\n");
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return;
	}	
	private static void retrieveByZip(LinkedList<Address> book, Scanner kb) {
		System.out.println("Please enter the specified zip code:");
		String zip=kb.next();
		
		int size=book.size();
		for(int i=0; i<size;i++) {
			Address temp = book.removeFromFront();
			if(temp.getZip().equals(zip)) {
				System.out.println(temp+"\n");
			}
			book.insertAtBack(temp);
		}
		System.out.print("enter any input to continue:");
		kb.next();
		
	}
	private static void modifyRecord(LinkedList<Address> book, Scanner kb) {
		System.out.println("Please enter the last name of the record you wish to modify");
		String name= kb.nextLine();
		String field, replacement;
		int size=book.size();
		Address temp = null;
		Boolean found=false;
		int i= 0; 
		
		while(i<size && !found) {
			temp=book.removeFromFront();
			if(temp.getLname().equals(name)) 
				found=true;
			else
				book.insertAtBack(temp);
			
			i++;
		}
		if(found) {
			System.out.println("Entry was found:\n" + temp+
					"\n\nWhich part do you wish to change? (select the number)\n"
					+"1)First Name\n"
					+ "2)Last Name\n"
					+ "3)Street Address\n"
					+ "4)City\n"
					+ "5)State\n"
					+ "6)Zip\n"
					+ "7)Country\n"
					+ "8)Phone:");
			field=kb.nextLine();
			System.out.println("What do you want to replace the field with?");
			replacement=kb.nextLine();
			
			switch(field) {
				case "1":
					temp.setFname(replacement);
					System.out.println("The field was changed\n"+temp);
					break;
				case "2":
					temp.setLname(replacement);
					break;
				case "3":
					temp.setStreet(replacement);
					break;
				case "4":
					temp.setCity(replacement);
					break;
				case "5":
					temp.setState(replacement);
					break;
				case "6":
					temp.setZip(replacement);
					break;
				case "7":
					temp.setCountry(replacement);
					break;
				case "8":
					temp.setPhone(replacement);
					break;
				default :
					System.out.println("Invalid field. Returning to main manu");
					pause();
			}
			book.insertAtBack(temp);
			
		}else {
			System.out.println("Entry was not found will be redirected to main menu");
			pause();
		}
		
	}
	private static void deleteRecord(LinkedList<Address> book, Scanner kb) {
		System.out.println("please enter the Last Name of the record you wish to DELETE");
		String name= kb.next();
		String confirm;
		int size=book.size();
		Address temp = null;
		Boolean found=false;
		int i= 0; 
		
		while(i<size && !found) {
			temp=book.removeFromFront();
			if(temp.getLname().equals(name)) 
				found=true;
			else
				book.insertAtBack(temp);
			
			i++;
		}
		if(found) {
			System.out.println("Entry was found:\n" + temp+
					"\n\nAre you sure you wish to delete?Y/N:");
			
			confirm=kb.next().toUpperCase();
			
			switch(confirm) {
				case "Y":
					System.out.println("File Was deleted. Returning to main manu");
					break;
				case "N":
					System.out.println("File Was not deleted. Returning to main manu");
					book.insertAtBack(temp);
					pause();
					break;
				default :
					System.out.println("Invalid input. Returning to main manu");
					book.insertAtBack(temp);
					pause();
			}
			
			
		}else {
			System.out.println("Entry was not found will be redirected to main menu");
			pause();
		}
	}
	private static void viewRecord(LinkedList<Address> book, Scanner kb) {
		System.out.println("please enter the Last Name of the record you wish to view");
		String name= kb.next();
		int size=book.size();
		Address temp = null;
		Boolean found=false;
		int i= 0; 
		
		while(i<size && !found) {
			temp=book.removeFromFront();
			if(temp.getLname().equals(name)) 
				found=true;
			book.insertAtBack(temp);
			i++;
		}
		if(found) {
			System.out.println("Entry was found:\n" + temp);
		}
		
	}
	private static void addRecord(LinkedList<Address> book, Scanner kb) {
		
		String field;
		String confirm;
		Address temp = new Address();
		boolean add=false;
		
		System.out.println("Please enter the first name of the new record:");
		field= kb.nextLine();
		temp.setFname(field);
		System.out.println("Please enter the last name of the new record:");
		field= kb.nextLine();
		temp.setLname(field);
		System.out.println("Please enter the Street Address of the new record:");
		field= kb.nextLine();
		temp.setStreet(field);
		System.out.println("Please enter the city of the new record:");
		field= kb.nextLine();
		temp.setCity(field);
		System.out.println("Please enter the state of the new record:");
		field= kb.nextLine();
		temp.setState(field);
		System.out.println("Please enter the zip code of the new record:");
		field= kb.nextLine();
		temp.setZip(field);
		System.out.println("Please enter the Country of the new record:");
		field= kb.nextLine();
		temp.setCountry(field);
		System.out.println("Please enter the phone number of the new record:");
		field= kb.nextLine();
		temp.setPhone(field);
		
		while(!add) {
			System.out.println(temp+"\n\nDo you want to add this to the Address Book?Y/N");
			confirm=kb.next().toUpperCase();
			switch(confirm) {
			case "Y":
				System.out.println("File was added to address book");
				book.insertAtBack(temp);
				add=true;
				pause();
				break;
			case "N":
				System.out.println("File Was not added to address book");
				add=true;
				pause();
				break;
			default :
				System.out.println("Invalid input.\n");
				pause();
		}
		}
	}
	public static void printAddressBook(LinkedList<Address> book) {
		int size= book.size();
		Address temp;
		for(int i=0; i<size;i++) {
			temp= book.removeFromFront();
			System.out.println(temp+"\n");
			book.insertAtBack(temp);
		}
	}
	
	//utility methods
	public static void clear() {
		for(int i=1; i<2; i++){
			System.out.println("\n\n\n\n\n");
		}
	}
	public static void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Address implements Comparable<Address>{
	private String fname, lname, street, city, state, zip, country, phone;
	
	public Address() {
		fname="";
		lname="";
		street="";
		city="";
		state="";
		zip="";
		country="";
		phone="";
		return;
	}	
	public Address(String fname,String lname,String street,String city,
			String state, String zip,String country,String phone) {
		this.fname=fname;
		this.lname=lname;
		this.street=street;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.country=country;
		this.phone=phone;
		
		return;
	}	
	@Override
	public String toString() {
		return fname + " " + lname + "\n" + street + "\n" + city + ", "
				+ state + " " + zip + "\n" + country + "\n" + phone;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(Address o) {
		return 0;
	}
	public void reset(){
		fname="";
		lname="";
		street="";
		city="";
		state="";
		zip="";
		country="";
		phone="";
		return;
	}
}
