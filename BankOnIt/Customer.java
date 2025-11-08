import java.util.*;

public class Customer extends User {
	CheckingAccount checking;
	SavingsAccount savings;

	public static void main(String[] args) {
		Customer guy = new Customer("Guy", "5555");
		boolean loggedIn = guy.login();
		if (loggedIn) {
			guy.start();
		} // end if
	} // end main def
	
	public Customer() {
		this.username = "anonymous";
		this.pin = "0000";
		this.checking = new CheckingAccount();
		this.savings = new SavingsAccount();
	} // end no-param constructor
	
	public Customer(String username, String pin) {
		this.username = username;
		this.pin = pin;
		this.checking = new CheckingAccount();
		this.savings = new SavingsAccount();
	} // end constructor
	
	public String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nCustomer Menu\n");
		System.out.println("0) Exit\n1) Manage Checking Account\n2) Manage Savings Account\n3) Change PIN\n");
		System.out.print("Action: ");
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
				System.out.println("Checking Account");
				this.checking.start();
			} else if (input.equals("2")) {
				System.out.println("Savings Account");
				this.savings.start();
			} else if (input.equals("3")) {
				changePin();
			} // end elseif
		} // end while loop
	} // end start
	
	public void changePin() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a new PIN: ");
		String response = input.nextLine();
		this.setPin(response);
		System.out.println("New pin is " + this.pin);
	} // end changePin
	
	public String getReport() {
		return "User: " + username + ", Checking: " + checking.getBalanceString() + ", Savings: " + savings.getBalanceString();
	} // end getReport
} // end class def
