package Bank;

import java.util.ArrayList;

public class Bank {
	
	
	private String name;
	private String adress;
	private ArrayList<BankProducts> bankProducts;
	private double moneyInCash;
	private double bankReserve;
	
	public Bank(String name, String adress) {
		this.name = name;
		this.adress = adress;
		this.moneyInCash=0;
		this.bankReserve=0;
		bankProducts=new ArrayList<>();
		
	}
	
	private void setMoneyInCash(double money){
		this.moneyInCash+=money;
		this.bankReserve+=money*0.1;
	}

	public BankProducts takeDeposit(double money, int time){
		if(time<12){
			this.bankProducts.add(new Deposit("Short Deposit",0.03, time, money));
		}
		else{
			this.bankProducts.add(new Deposit("Long Deposit",0.05, time, money));
		}
		this.setMoneyInCash(money);
		return bankProducts.get(bankProducts.size()-1);
	}
	
	public BankProducts grantCredit(double money, int time, double yearRate){
		if(money<this.moneyInCash-this.bankReserve){
			if(time<30){
				this.bankProducts.add(new Credit("Consumer Credit",yearRate, time, money));
			}
			else{
				this.bankProducts.add(new Credit("Home Credit",yearRate, time, money));
			}
			this.setMoneyInCash(-money);
			return bankProducts.get(bankProducts.size()-1);
		}
		else{
			System.out.println("The bank does't have enough money to grant this credit");
			return null;
		}
	}
	
	public void payDepositsRent(){
		
		for (BankProducts bankProducts2 : bankProducts) {
			if(bankProducts2 instanceof Deposit){
				Deposit temp= (Deposit) bankProducts2;
				this.setMoneyInCash(-temp.getMonthlyPayment());
				temp.setAmount(temp.getAmount()+temp.getMonthlyPayment());
				
				
			}
		}
		
	}
	@Override
	public String toString() {
		StringBuffer info = new StringBuffer();
		info.append("Bank name- "+this.name+System.lineSeparator()+ "Adress- "+this.adress+System.lineSeparator());
		info.append("Money in cash- "+this.moneyInCash+System.lineSeparator()+"Bank reserve- "+this.bankReserve+System.lineSeparator());
		for (BankProducts bankProducts2 : bankProducts) {
			info.append(bankProducts2.toString());
		}
		
		return info.toString();
	}
	

	
	
	
	
	
	
	

}
