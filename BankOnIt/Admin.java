import java.util.*;

public class Admin extends User {

	public static void main(String[] args) {
		Admin guy = new Admin();
		guy.menu();
		guy.getReport();
	} // end main def
	
	public Admin() {
		this.username = "admin";
		this.pin = "0000";
	} // end no-param constructor
	
	public Admin(String adminName, String adminPin) {
		this.username = adminName;
		this.pin = adminPin;
	} // end constructor
	
	public String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nAdmin Menu\n");
		System.out.println("0) Exit \n1) Full Customer Report \n2) Add User \n3) Apply Interest to Savings Accounts\n");
		System.out.print("Action 0-3: ");
		String response = input.nextLine();
		return response;
	} // end menu
	
	public void start() {
		
		//this method does nothing

	} // end start
	
	public String getReport() {
		String result = "";
		result += "Admin Details\n";
		result += "Username: " + this.getUsername() + "\n";
		result += "PIN: " + this.getPin() + "\n";
		return result;
	} // end getReport

} // end class def
