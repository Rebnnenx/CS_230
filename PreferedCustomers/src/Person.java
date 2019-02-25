
public class Person {
	
	private String fName;
	private String lName;
	private String address;
	private String pNumber;
	private String street;
	private String remainingAddress;
	
	public Person() {
		
		fName = "";
		lName = "";
		address = "";
		pNumber = "";
		street="";
		remainingAddress="";
	}
	
	public Person(String fn, String ln, String ad, String num) {
		
		fName = fn;
		lName = ln;
		address = ad;
		pNumber = num;
		splitAddress();
	}
	

	public Person(Person other) {
		
		this.fName = other.fName;
		this.lName = other.lName;
		this.address = other.address;
		this.pNumber = other.pNumber;
	}
	
	//set methods
	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public void setName(String fn, String ln) {
		fName = fn;
		lName = ln;
	}
	
	//get methods
	public String getfName() {
		return fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public String getName() {
		return fName+" "+lName;
	}
	

	public String getAddress(int flag) {
		if(flag == -1)
			return address;
		else
			return street+"\n"+remainingAddress;
	}
	
	public String getpNumber() {
		return pNumber;
	}
	
	private void splitAddress() {
		String[] array= address.split(", ", 2);
		street=array[0];
		remainingAddress=array[1];		
	}
	
	public Person copy() {
		Person copy=new Person(this.fName,this.lName,this.address,
								this.pNumber);
		
		return copy;
	}
	
	public String toString() {
		
		String str = new String(fName+ " "+ lName +"\n Address: \n"+ street+
				             "\n"+remainingAddress+"\nPhone Number\n"+pNumber);
		return str;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (pNumber == null) {
			if (other.pNumber != null)
				return false;
		} else if (!pNumber.equals(other.pNumber))
			return false;
		return true;
	}
	
	
}