public class SavingsAccount extends CheckingAccount {
	private double interestRate;

	public SavingsAccount() {
		this.interestRate = 1;
	} // end no-param constructor
	
	public SavingsAccount(double balance) {
		super(balance);
		this.interestRate = 1;
	} // end constructor
	
	public SavingsAccount(double balance, double interest) {
		super(balance);
		this.interestRate = interest;
	} // end constructor
	
	public static void main(String[] args) {
		SavingsAccount account = new SavingsAccount(1000.0);
		account.start();
		account.setInterestRate(1.1);
		account.calcInterest();
		account.start();
	} // end main
	
	public void calcInterest() {
		this.setBalance(this.getBalance() * this.interestRate);
	} // end calcInterest
	
	public void setInterestRate(double amount) {
		this.interestRate = amount;
	} // end setInterestRate
	
	public double getInterestRate() {
		return this.interestRate;
	} // end getInterestRate
} // end class def
