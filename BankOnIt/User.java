import java.util.*;
import java.io.*;

public abstract class User implements HasMenu, Serializable {
	protected String username;
	protected String pin;

	public boolean login() {
		Scanner input = new Scanner(System.in);
		boolean result = false;
		System.out.print("Username: ");
		String inUsername = input.nextLine();
		if (inUsername.equals(this.username)) {
			System.out.print("PIN: ");
			String inPin = input.nextLine();
			if (inPin.equals(this.pin)) {
				System.out.println("Login successful");
				result = true;
			} else {
				System.out.println("Invalid pin...");
			} // end elseif
		} else {
			System.out.println("Invalid username...");
		} // end elseif
		return result;
	} // end no-param login
	
	public boolean login(String username, String pin) {
		boolean result = false;
		if (username.equals(this.username)) {
			if (pin.equals(this.pin)) {
				result = true;
			} // end if
		} // end if
		return result;
	} // end login
	
	public void setUsername(String username) {
		this.username = username;
	} // end setUsername
	
	public String getUsername() {
		return this.username;
	} // end getUsername
	
	public void setPin(String pin) {
		// forcing pin to all numbers
		if (pin.matches("^\\d{4}$")) {
			this.pin = pin;
		} else {
			System.out.println("Pin must be 4 digits, with all digits being numeric");
			System.out.println("Setting pin to '0000' ");
			this.pin = "0000";
		} // end elseif
	} // end setPin
	
	public String getPin() {
		return this.pin;
	} // end getPin
	
	public abstract String getReport();

} // end class def
