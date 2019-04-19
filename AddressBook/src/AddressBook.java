import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook<T extends Comparable<T>>{
	
	public static void main(String[] args) throws IOException {
		
		LinkedList<Address> book= new LinkedList<Address>();
		boolean found=true, exit = false, changes=false;
		FileWriter fw = null;
		Scanner kb= new Scanner(System.in);
		int option;
		String ln, confirm=null;
		String[] line;
		File ab = new File("addresses.txt");
	    Scanner fr = new Scanner(ab);
		Address newAddress=new Address();
		
		
			try {
				fw= new FileWriter(ab);
			} catch (FileNotFoundException fe) {
				System.out.println("File was not found, program will now end.");
				found=false;
			}
		if(found) {
			System.out.println(fr.hasNextLine());
			while(fr.hasNextLine()) {
				ln=fr.nextLine();
				line=ln.split(" ");
				newAddress.setFname(line[1]);
				newAddress.setLname(line[2]);
				
				ln=fr.nextLine();
				newAddress.setStreet(ln);
				
				ln=fr.nextLine();
				line=ln.split(" ");
				newAddress.setCity(line[1].substring(0, line[1].length()));
				newAddress.setState(line[2]);
				newAddress.setZip(line[3]);
				
				ln=fr.nextLine();
				newAddress.setCountry(ln);
				
				ln=fr.nextLine();
				newAddress.setPhone(ln);
				book.insertAtBack(newAddress);
				System.out.println("test");
			}
			System.out.println(book);
			do {
				clear();
				System.out.println("Thank you for using this random Address Book manager. These are the availabe operations."
								+ " Select one by inputting the desired number:\n");
				System.out.println("1.Add a new address record\n"
						+ "2.View an existing address record\n"
						+ "3.Delete an existing address record\n"
						+ "4.Modify an existing address record\n"
						+ "5.Save the entire address book in a file\n"
						+ "6.Retrieve all address entries using zip code\n"
						+ "7.Print the entire address book on the screen\n"
						+ "0.Exit the program");
				option= kb.nextInt();
				
				clear();
				
				switch(option) {
				
					case 1:{
						
						break;
					}
					case 2:{
						
						break;
					}
					
					case 3:{
						
						break;
					}
					case 4:{
						
						break;
					}
					case 5:{
						
						break;
					}
					case 6:
						
						break;
					case 7:
						
						break;
					case 0:{
						exit= true;
						if(changes) {
							do {
								clear();
								System.out.println("There are unsaved changes. Save? Y/N");
								confirm= kb.nextLine().toUpperCase();
								switch(confirm){
								
									case "Y":
									//	saveFile();
										System.out.println("File was saved. Goodbye");
										break;
									case "N":
										System.out.println("File was not saved. Goodbye");
										break;
									default:
										System.out.println("incorrect input");
										
								}
							}while(!confirm.equals("Y"));
							
						}
						break;
					}
					default:{
						System.out.println("Incorrect Input. Options will be redisplayed");
						pause();
					}
				
				}
			}while(!exit);
		}
		kb.close();
		fr.close();
		fw.close();
	}
	public static void clear() {
		for(int i=1; i<2; i++){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
	}
	
	public static void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
class Address implements Comparable<Address>{
	private String fname, lname, street, city, state, zip, country, phone;
	
	public Address() {
		fname=lname=street=city=state=zip=country=phone=null;
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
		return fname + ", " + lname + "\n" + street + "\n" + city + ", "
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
		// TODO Auto-generated method stub
		return 0;
	}
	public void reset(){
		fname=lname=street=city=state=zip=country=phone=null;
		return;
	}
}
