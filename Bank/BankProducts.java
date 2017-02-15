package Bank;

public abstract class BankProducts {
	
	String name;
	double yearRate;
	int timeOfProduct;
	
	public BankProducts(String name, double yearRate, int timeOfProduct) {
		this.name = name;
		this.yearRate = yearRate;
		this.timeOfProduct = timeOfProduct;
	}
	
	abstract void monthlyPayments();
	public abstract String toString();
	
	

}
