package Bank;

public class Credit extends BankProducts {
	
	private double monthlyPayment; // + or - if it's credit or deposit
	private double amount;

	public Credit(String name, double yearRate, int timeOfProduct, double amount) {
		super(name, yearRate, timeOfProduct);
		this.amount=amount;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	
	

	
	@Override
	void monthlyPayments() {
		double monthRate=this.yearRate/12;
		double credit=this.amount;
		for (int i = 0; i < this.timeOfProduct; i++) {
			credit+=credit*monthRate;
		}
		
		this.monthlyPayment=-credit/this.timeOfProduct;
	}
	
	public static double creditCalculator(int time, double amount, double yearRate){
		double monthRate=yearRate/12;
		double credit=amount;
		for (int i = 0; i < time; i++) {
			credit+=credit*monthRate;
		}
		return credit/time;
	}

	@Override
	public String toString() {
		StringBuffer info = new StringBuffer();
		info.append("Credit- "+this.name+System.lineSeparator()+ "Amount- "+this.amount+System.lineSeparator()+"Year Rate- "+this.yearRate+System.lineSeparator());
		return info.toString();
	}
	
	

}
