import java.util.*;

public class Customer extends User {
	ArrayList<CheckingAccount> checking = new ArrayList<>();
	ArrayList<SavingsAccount> savings = new ArrayList<>();

	public static void main(String[] args) {
		Customer guy = new Customer("Guy", "5555");
		guy.start();
	} // end main def
	
	public Customer() {
		this.username = "anonymous";
		this.pin = "0000";
		this.checking.add(new CheckingAccount());
		this.savings.add(new SavingsAccount());
	} // end no-param constructor
	
	public Customer(String username, String pin) {
		this.username = username;
		this.pin = pin;
		this.checking.add(new CheckingAccount());
		this.savings.add(new SavingsAccount());
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
					selectAccount(checking);
				} else if (input.equals("2")) {
					selectAccount(savings);
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
	
	public void selectAccount(ArrayList<? extends CheckingAccount> accounts) {
		Scanner input = new Scanner(System.in);
		if (accounts.size() > 0) {
			if (accounts.size() == 1) {
				accounts.get(0).start();
			} else {
				System.out.println("Please select an account\n");
				for (int i = 0; i < accounts.size(); i++) {
					System.out.println("Account " + i + ": " + accounts.get(i).getBalanceString());
				} // end for loop
				System.out.print("\nPlease enter 0-" + (accounts.size()-1) + ": ");
				int target;
				try {
					String response = input.nextLine();
					target = Integer.parseInt(response);
				} catch (NumberFormatException e) {
					target = -1;
				} // end try-catch
				if (target >= 0 && target < accounts.size()) {
					accounts.get(target).start();
				} else {
					System.out.println("Invalid account input...");
				} // end elseif
			} // end elseif
		} // end if
	} // end selectAccount
} // end class def
