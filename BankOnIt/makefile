Bank.class: Bank.java Customer.class User.class Admin.class CheckingAccount.class SavingsAccount.class HasMenu.class
	javac -g Bank.java

Customer.class: Customer.java User.class CheckingAccount.class SavingsAccount.class
	javac -g Customer.java

User.class: User.java HasMenu.class
	javac -g User.java

Admin.class: Admin.java User.class HasMenu.class
	javac -g Admin.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.class
	javac -g SavingsAccount.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

testAdmin: Admin.class
	java Admin

testCustomer: Customer.class
	java Customer

testChecking: CheckingAccount.class
	java CheckingAccount

testSavings: SavingsAccount.class
	java SavingsAccount

run: Bank.class
	java Bank

clean:
	rm *.class

reset: Customers.dat
	rm Customers.dat
