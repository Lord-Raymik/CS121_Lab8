import java.util.*;

public class Customer extends User {
	CheckingAccount checking;
	SavingsAccount savings;

	public static void main(String[] args) {
		Customer guy = new Customer("Guy", "5555");
		guy.start();
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
		System.out.print("Please enter 0-3: ");
		String response = input.nextLine();
		return response;
	} // end menu
	
	public void start() {
		boolean loggedIn = this.login();
		if (loggedIn == true) {
			boolean keepGoing = true;
			while (keepGoing) {
				String input = menu();
				if (input.equals("0")) {
					keepGoing = false;
				} else if (input.equals("1")) {
					this.checking.start();
				} else if (input.equals("2")) {
					this.savings.start();
				} else if (input.equals("3")) {
					changePin();
				} // end elseif
			} // end while loop
		} // end if
	} // end start
	
	public void changePin() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a new PIN: ");
		String response = input.nextLine();
		this.setPin(response);
		System.out.println("New pin is " + this.pin);
	} // end changePin
	
	public String getReport() {
		return "";
	} // end getReport
} // end class def
