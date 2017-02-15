package Demo;

import java.util.Random;

import Bank.Bank;
import Client.Client;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Bank bnb = new Bank("BNB", "Sofiq");
		
		Client[] $clients = new Client[10];
		String[] names = {"Pesho", "Sasho","Penka","Sashka","Misho","Ivan","Ivanka","Gosho"};
		String[] adreses= {"Lulin", "Mladost","Obelq","Stud. Grad","Drujba","Durvenica","Man. Livadi","Nadejda"};
		
		Random r= new Random();
		
		for (int i = 0; i < $clients.length; i++) {
			$clients[i] = new Client(names[r.nextInt(8)], adreses[r.nextInt(8)], r.nextDouble()*10000+5000, r.nextDouble()*1000+1000);
			$clients[i].openADeposit(bnb,($clients[i].getMoneyInCash()*(r.nextInt(20)+80)/100) , r.nextInt(60)+1);
			System.out.println($clients[i].toString());
		}
		
		System.out.println(bnb.toString());
		
		double[] creditRate = {0.06, 0.1};
		
		for (int i = 0; i < $clients.length; i++) {
			
			$clients[i].applyForCredit(bnb,r.nextDouble()*10000+5000 ,r.nextInt(60)+1, creditRate[r.nextInt(2)]);
			System.out.println($clients[i].toString());
		}
		
		System.out.println(bnb.toString());
		
		
	}

}
