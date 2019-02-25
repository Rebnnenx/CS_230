
public class PreferredCustomer extends Customer{
	
	private double total;
	private String discount = "";
	
	public PreferredCustomer() {
		super();
		total=0;
		updateDiscount();
	}
	
	public PreferredCustomer(String fn,String ln, String ad, String pn,
			String cn, boolean ml,double tot) {
		
		super(fn,ln,ad,pn,cn,ml);
		
		total=tot;
		updateDiscount();
	}
	
	public PreferredCustomer(Customer other, double tot) {
		
		super(other);
		
		total=tot;
		updateDiscount();
	}
	
	public PreferredCustomer(PreferredCustomer other) {
		super(other.getfName(), other.getlName(),
				other.getAddress(-1), other.getpNumber(),other.getCustNum(),
				other.getMailList());
		
		this.total= other.total;
		updateDiscount();
	}
	
	
	public void updateDiscount() {
		
		if(total<500)
			discount= "0%";
		
		if(total>=500 && total<1000) 
			discount= "5%";
		
		if(total>=1000 && total<1500) 
			discount= "6%";
		
		if(total>=1500 && total<2000) 
			discount= "7%";
		
		if(total>=2000) 
			discount= "10%";
		
	}
	
	public void updateTotal(double addition) {
		total=+addition;
		updateDiscount();
	}
	
	public void setTotal(double total) {
		this.total = total;
		updateDiscount();
	}
	public double getTotal() {
		return total;
	}

	public String getDiscount() {
		return discount;
	}
	
	public PreferredCustomer copy() {
		
		PreferredCustomer copy = new PreferredCustomer(this.getfName(), 
				this.getlName(),this.getAddress(-1), this.getpNumber(),
				this.getCustNum(),this.getMailList(), this.total);
		
		return copy;
	}
	
	public String toString() {
		
		return this.getName()+"\nAddress:\n"+this.getAddress(0)+
				"\nPhone Number: " + this.getpNumber()
				+ "\nCustomer Number: " +this.getCustNum() +
				"\n On Mailing List: "+this.getMailList()+"\nTotal Spent: "
				+ this.total ;
	}
	

}
