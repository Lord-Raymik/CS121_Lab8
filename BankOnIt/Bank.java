import java.util.*;
import java.io.*;

public class Bank implements HasMenu, Serializable {
	Admin admin;
	CustomerList customers;

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.start();
	} // end main def
	
	public Bank() {
		admin = new Admin();
		this.loadCustomers();
		if (customers == null) {
			this.loadSampleCustomers();
		} // end if
	} // end constructor
	
	public String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nBank Menu\n");
		System.out.println("0) Exit system \n1) Login as admin \n2) Login as customer \n");
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
				this.saveCustomers();
			} else if (input.equals("1")) {
				//Scanner loginInput = new Scanner(System.in);
				System.out.println("\nAdmin login");
				//System.out.print("Username: ");
				//String username = loginInput.nextLine();
				//System.out.print("PIN: ");
				//String pin = loginInput.nextLine();
				boolean success = this.admin.login();
				if (success == true) {
					this.startAdmin();
				} 
				/*else {
					System.out.println("Invalid login...");
				} // end elseif */
			} else if (input.equals("2")) {
				this.loginAsCustomer();
			} // end elseif
		} // end while loop
	} // end start
	
	public void startAdmin() {
		boolean keepGoing = true;
		while (keepGoing) {
			String input = this.admin.menu();
			if (input.equals("0")) {
				keepGoing = false;
			} else if (input.equals("1")) {
				this.fullCustomerReport();
			} else if (input.equals("2")) {
				this.addUser();
			} else if (input.equals("3")) {
				this.applyInterest();
			} // end elseif
		} // end while loop
	} // end startAdmin
	
	public void loginAsCustomer() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nCustomer login");
		System.out.print("Username: ");
		String username = input.nextLine();
		System.out.print("PIN: ");
		String pin = input.nextLine();
		int customerIndex = -1;
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).login(username, pin) == true) {
				customerIndex = i;
			} // end if
		} // end for loop
		if (customerIndex >= 0) {
			customers.get(customerIndex).start();
		} else {
			System.out.println("Customer not found...");
		} // end elseif
	} // end loginAsCustomer
	
	public void fullCustomerReport() {
		System.out.println("Full customer report");
		for (Customer current : customers) {
			System.out.println(current.getReport());
		} // end for each loop
	} // end fullCustomerReport
	
	public void addUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Add user");
		System.out.print("Name: ");
		String username = input.nextLine();
		System.out.print("PIN: ");
		String pin = input.nextLine();
		customers.add(new Customer(username, pin));
	} // end addUser
	
	public void applyInterest() {
		System.out.println("Apply interest");
		for (Customer current : customers) {
			current.savings.calcInterest();
			System.out.println("New balance: " + current.savings.getBalanceString());
		} // end for each loop
	} // end applyInterest
	
	public void loadSampleCustomers() {
		customers = new CustomerList();
		Customer a = new Customer("Mike", "1111");
		Customer b = new Customer("Johnathan", "2222");
		Customer c = new Customer("Elijah", "3333");
		customers.add(a);
		customers.add(b);
		customers.add(c);
	} // end loadSampleCustomers
	
	public void saveCustomers() {
		try {
			FileOutputStream fo = new FileOutputStream("Customers.dat");
			ObjectOutputStream obIn = new ObjectOutputStream(fo);
			obIn.writeObject(customers);
			fo.close();
			obIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end try catch
	} // end saveCustomers
	
	public void loadCustomers() {
		try {
			FileInputStream fIn = new FileInputStream("Customers.dat");
			ObjectInputStream obIn = new ObjectInputStream(fIn);
			customers = (CustomerList)obIn.readObject();
			fIn.close();
			obIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		} // end try catch
	} // end loadCustomers

} // end class def

class CustomerList extends ArrayList<Customer> implements Serializable {};
