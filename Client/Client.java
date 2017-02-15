package Client;

import java.util.ArrayList;

import Bank.Bank;
import Bank.Credit;
import Bank.Deposit;

public class Client {
	
	private String name;
	private String adress;
	private double moneyInCash;
	private double monthlySalary;
	private ArrayList<Deposit> deposits;
	private ArrayList<Credit> credits;
	
	
	public Client(String name, String adress, double moneyInCash, double monthSalary) {
		this.name = name;
		this.adress = adress;
		this.moneyInCash = moneyInCash;
		this.monthlySalary = monthSalary;
		deposits = new ArrayList<Deposit>();
		credits = new ArrayList<Credit>();
	}
	
	public boolean openADeposit(Bank bank, double d, int time){
		if(this.moneyInCash-d>=0){
			this.deposits.add((Deposit) bank.takeDeposit(d, time));
			this.moneyInCash-=d;
			return true;
		}
		else{
			System.out.println("Not enough money for this operation");
			return false;
		}
	}
	
	public boolean applyForCredit(Bank bank, double money, int time, double yearRate){
		if(this.monthlySalary*0.5>this.getMontlyPaymentsOnLoans()+Credit.creditCalculator(time, money, yearRate)){
			this.credits.add((Credit) bank.grantCredit(money, time, yearRate));
			this.moneyInCash+=money;
			return true;
		}
		else{
			System.out.println("You don't have enough profits to pay for this credit");
			return false;
		}
		
	}
	
	public boolean monthlyPaymentOnLoans(){
		if(this.moneyInCash>=this.getMontlyPaymentsOnLoans()){
			this.moneyInCash-=this.getMontlyPaymentsOnLoans();
			return true;
		}
		else{
			System.out.println("You don't have enough money to pay your credits");
			return false;
		}
	}
	
	
	public double getMoneyInCash() {
		return this.moneyInCash;
	}

	public double getMontlyPaymentsOnLoans(){
		double amount =0;
		for (Credit credit : credits) {
			amount+=credit.getMonthlyPayment();
		}
		return amount;
	}
	@Override
	public String toString() {
		StringBuffer info = new StringBuffer();
		info.append("Client- "+this.name+System.lineSeparator()+ "Adress- "+this.adress+System.lineSeparator());
		info.append("Money in cash- "+this.moneyInCash+System.lineSeparator()+"Month salary- "+this.monthlySalary+System.lineSeparator());
		for (Credit credit : credits) {
			info.append(credit.toString());
		}
		for (Deposit deposit : deposits) {
			info.append(deposit.toString());
		}
		return info.toString();
	}
	
	

}
