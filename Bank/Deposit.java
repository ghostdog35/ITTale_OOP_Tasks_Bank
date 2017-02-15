package Bank;

public class Deposit extends BankProducts {
	
	private double monthlyPayment; // + or - if it's credit or deposit
	private double amount;

	public Deposit(String name, double yearRate, int timeOfProduct, double amount) {
		super(name, yearRate, timeOfProduct);
		this.setAmount(amount);
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
		this.monthlyPayments();
	}

	@Override
	void monthlyPayments() {
		this.monthlyPayment=((this.amount*this.yearRate)/12);
	}
	
	@Override
	public String toString() {
		StringBuffer info = new StringBuffer();
		info.append("Deposit- "+this.name+System.lineSeparator()+ "Amount- "+this.amount+System.lineSeparator()+"Year Rate- "+this.yearRate+System.lineSeparator());
		return info.toString();
	}
	
	
	
	
	
	

}
