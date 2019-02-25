
public class Customer extends Person{
	private String custNum;
	private boolean mailList;
	
	
	public Customer() {
		
		super();
		custNum="";
		mailList=false;
	}
	
	
	public Customer(String fn,String ln, String ad, String pn,
					String cn, boolean ml) {
		
		super(fn, ln, ad, pn);
		
		custNum= cn;
		mailList = ml;
		
	}
	
	public Customer(Person other, String cn, boolean ml) {
		
		super(other);
		
		custNum= cn;
		mailList = ml;
	}

	public Customer(Customer other) {
		
		super(other.getfName(), other.getlName(),
				other.getAddress(-1), other.getpNumber());
		
		custNum= other.custNum;
		mailList = other.mailList;
		
	}


	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}


	public void setMailList(boolean mailList) {
		this.mailList = mailList;
	}


	public String getCustNum() {
		return custNum;
	}


	public boolean getMailList() {
		return mailList;
	}


	public String toString() {
		return super.toString()+" "+ custNum + " " + mailList + ".";
	}
	
	
}
