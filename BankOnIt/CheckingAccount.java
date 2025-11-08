import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable {
	private double balance;


	public CheckingAccount() {
		this.balance = 0;
	} // end no-param constructor
	
	public CheckingAccount(double balance) {
		this.balance = balance;
	} // end constructor
	
	public static void main(String[] args) {
		CheckingAccount account = new CheckingAccount(1000.0);
		account.start();
	} // end main
	
	public String menu() {
		System.out.println("\nAccount menu\n");
		System.out.println("0) quit\n1) check balance\n2) make a deposit\n3) make a withdrawal\n");
		System.out.print("Action: ");
		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		return response;
	} // end menu
	
	public void start() {
		boolean keepGoing = true;
		while (keepGoing) {
			String input = menu();
			if (input.equals("0")) {
				keepGoing = false;
			} else if (input.equals("1")) {
				checkBalance();
			} else if (input.equals("2")) {
				makeDeposit();
			} else if (input.equals("3")) {
				makeWithdrawal();
			} // end elseif
		} // end while loop
	} // end start
	
	public double getBalance() {
		return balance;
	} // end getBalance
	
	public String getBalanceString() {
		return String.format("$%.02f", this.balance);
	} // end getBalanceString
	
	public void setBalance(double balance) {
		this.balance = balance;
	} // end setBalance
	
	public void checkBalance() {
		System.out.println("Checking balance...");
		System.out.println("Current balance: " + this.getBalanceString());
	} // end checkBalance
	
	public void makeDeposit() {
		System.out.println("Making a deposit...");
		System.out.print("How much to deposit? ");
		double amount = getDouble();
		this.balance += amount;
		System.out.println("New balance: " + getBalanceString());
	} // end makeDeposit
	
	public void makeWithdrawal() {
		System.out.println("Making a withdrawal...");
		System.out.print("How much to withdraw? ");
		double amount = getDouble();
		if (amount > this.balance) {
			System.out.println("Insufficient funds");
		} else {
			this.balance -= amount;
		} // end elseif
		System.out.println("New balance: " + getBalanceString());
	} // end makeWithdrawal
	
	private double getDouble() {
		Scanner input = new Scanner(System.in);
		try {
			return input.nextDouble();
		} catch (Exception e) {
			return 0.0;
		} // end try
	} // end getDouble
} // end class def
