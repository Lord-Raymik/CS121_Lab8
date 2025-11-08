# Algorithm Documentation for BankOnIt

## Classes

### HasMenu
This is an interface for classes that have some sort fo functionality as a menu  

### CheckingAccount
This is a class representing a standard checking account for a customer. It effectively is wrapper around a single double value, which is the balance.  
CheckingAccount also implements the HasMenu interface  

### SavingsAccount
This is a subclass of ChackingAccount, which adds a variety of new features which are used for calculating interest  

### User
This is an abstract class which is the base for both Customer and Admin. It generally is to contain basic features relating to logging in.  
User also implements the HasMenu interface  

### Customer
This is a subclass of User which contains both a ChecckingAccount and a SavingsAccount.

## General Algorithm

*note: HasMenu is an interface and has no algorithm of any kind*  

### CheckingAccount

#### Variables
balance - double: This is the only variable in the class, which the class is effectively a wrapper for  

#### Methods

public CheckingAccount()  
```
set balance to 0
```

public CheckingAccount(double Balance)  
```
set the account's balance to the constructor's balance parameter
```

public static void main(String[] args)  
```
create a new CheckingAccount containing $1000
call start on the newly created checking account
```

public String menu()  
```
Print the options for the user to select
Create a scanner object called input
use the input scanner to ask the user for a response, saving it to a variable appropriately called response
return the string in response
```

public void start()  
```
mkae boolean keepGoing, set it to true
while keepGoing is true
    call menu(), saving it's return value to a variable called input
    if input is "0"
        set keepGoing to false
    if input is "1"
        call checkBalance()
    if input is "2"
        call makeDeposit()
    if input is "3"
        call makeWithdrawal()
```

public double getBalance()  
```
return the current balance of the account
```

public String getBalanceString()  
```
return a formatted string containing the current account balance
```

public void setBalance(double balance)  
```
set the current account balance to the method's balance parameter
```

private double getDouble()  
```
create a new scanner called input
try
    use input to aks the user for a double, then return that value
catch
    if there is any form of exception caught, return 0.0
```

public void checkBalance()  
```
prints the current account balance to the console
```

public void makeDeposit()  
```
ask the user how much they would like to deposit
use getDouble() to get a double from the user, save the value to a variable called amount
increase the current account balance by amount
print the new account balance
```

public void makeWithdrawal()  
```
ask the user how much they would like to withdrawal
use getDouble() to get a double from the user, save the value to a variable called amount
if amount < balance
    tell the user they have insufficient funds
else
    decrease the current account balance by amount
print the new account balance
```

### SavingsAccount
This is a subclass of CheckingAccount

#### Variables
interestRate - double: this variable represents the interest rate on the account  

#### Methods

public SavingsAccount()  
```
set interestRate to 0
```

public SavingsAccount(double balance)  
```
set the account's balance to the constructor's balance parameter
```

public SavingsAccount(double balance, double interest)  
```
set the account's balance to the constructor's balance parameter
set the account's interestRate to the constructor's interest parameter
```

public static void main(String[] args)  
```
run the same as main initially
after main would normally end, instead calculate the interest rate
rerun the menu
```

public void calcInterest()  
```
multiply the account balance by the interest rate, set the balance to that newly calculated amount
```

public void setInterestRate(double amount)  
```
set the account's interestRate to amount
```

public double getInterestRate()  
```
return the account's interestRate
```

### User
This is an abstract class, representing features that all user's have in common. To be more specific, this class mostly contains features related to logging in.  

#### Variables
username - String: this variable represent's the recognized name of the user  
pin - String: this is the user's pin which they need to input to log in  

#### Methods

public boolean login()  
```
create a Scanner called input
create boolean called result, set it to false
use input to ask the user for their username, save it to a variable called inUsername
if inUsername equals username
    use input to ask the user for their pin, save it to a variable called inPin
    if inPin equals pin
        tell the user the login was successful
        set result to true
    else
        tell the user the pin is incorrect
else
    tell the user their username is invalid
return result
```

public boolean login(String inUsername, String inPin)  
```
create a boolean called result, set it to false
if inUsername equals username
    & if inPin equals pin
        set result to true
return result
```

public void setUsername(String username)  
```
set this.username to the method's username parameter
```

public String getUsername()  
```
return the current username
```

public void setPin(String pin)  
```
set this.pin to the method's pin parameter
```

public String getPin()  
```
return the current pin
```

public abstract String getReport()  
```
this has no defined algorithm here, as it is abstract
```

### Customer
This is a subclass of user  

#### Variables
checking - CheckingAccount: this represents the user's checking account  
savings - SavingsAccount: this represents the user's savings account  

#### Methods

public static void main(String[] args)  
```
Create a new Customer named guy, give him a username and pin
call start() on guy
```

public Customer()  
```
set username to 'anonymous'
set pin to '0000'
set checking to be a blank CheckingAccount (use the no-param constructor)
set savings to be a blank SavingsAccount (use the no-param constructor)
```

public Customer(String username, String pin)  
```
set username to the constructor's username parameter
set pin to the constructor's pin parameter
set checking to be a blank CheckingAccount (use no-param constructor)
set savings to be a blank SavingsAccount (use no-param constructor)
```

public String menu()  
```
create a scanner object called input
print the options for the user to select
ask the user for a response using the scanner, save it to a variable called response
return the value of response
```

public void start()  
```
make a boolean called keepGoing, set it to true
while keepGoing is true
    call menu(), saving it's returned value to a variable called input
    if input is "0"
        set keepGoing to true
    if input is "1"
        call start() on checking
    if input is "2"
        call start() on savings
    if input is "3"
        call changePin()
```

public void changePin()  
```
create a new scanner called input
tell the user to enter a new pin, save the response to a new variable called newPin
call setPin(String pin), using newPin as the value for the pin parameter
```

public String getReport()  
```
#I have not yet been told what this method is meant to do, so I will leave it blank for now#
```

### Admin
This is a subclass of user which represents the bank administrator  

#### Variables
The admin does not have any particular variables unique to it  

#### Methods

public static void main(String[] args)  
```
create a new admin called guy
run some type of test on him (dont have many to really try atm)
```

public Admin()  
```
set username to 'admin'
set pin to '0000'
```

public Admin(String name, String PIN)  
```
set username to name
set pin to PIN
```

public String menu()  
```
create a new scanner called input
print the different options for the user to pick from
using input, save the response from the user to a variable called response
return the value of response
```

public void start()  
```
this method does not do anything
```

public void getReport()  
```
print out the admin's username and pin
```

### Bank
This is the primary class for the program. It holds the list of all the customers, as well as the admin. It can be seen almost as the central point of the program.  
Bank also implements HasMenu.  

#### Variables
admin - Admin: this is the system administrator for the bank  
customers - ArrayList<Customer>: this is the list of all the customers in the bank which are stored in an ArrayList  

#### Methods

public static void main(String[] args)  
```
Create a new bank
call start() on the bank
```

public Bank()  
```
set admin to be a new Admin made with a default constructor
call loadCustomers() and set customers to equal it's return value
```

public String menu()  
```
Create a new Scanner called input
print out the valid actions for the user to select from
use input to ask the user what action they wantr to do, save their response in a string appropriately named response
return the value of response
```

public void start()  
```
make a boolean called keepGoing, set it to true
while keepGoing is true
    call menu(), save it's return value to a String called input
    if input is "0"
        set keepGoing to false
        call saveCustomers()
    if input is "1"
        create a new Scanner called loginInput
        use loginInput to ask the user for a username, save it to a String called username
        use loginInput to ask the user for a pin, save it to a String called pin
        call the admin's login() method with the username and pin variables as parameters, save the return value to a boolean called success
        if success is true
            call startAdmin()
    if input is "2"
        call loginAsCustomer()
```

public void startAdmin()  
```
create a new boolean called keepGoing, set it to true
while keepGoing is true
    call the admin's menu() method, save it to a String called input
    if input is "0"
        set keepGoing to false
    if input is "1"
        call fulCustomerReport()
    if input is "2"
        call addUser()
    if input is "3"
        call applyInterest()
```

public void loginAsCustomer()  
```
create a new Scanner called input
use input to ask the user for a username, save it to a String called username
use input to ask the user for a pin, save it to a String called pin
create an int called customerIndex, set it to -1
for customers.size() times, with current as the control variable
    if the current customer's login method returns true with username and pina s the parameters
        set customerIndex to current
if customerIndex >= 0
    call the associated customer's start() method
else
    tell the user no account was found
```

public void fullCustomerReport()  
```
for every customer in the customers ArrayList
    print the customer's name, checking account balance, and savings account balance
```

public void addUser()  
```
Create a new Scanner called input
use input to get a username from the user, save it to a String
use input to get a pin from the user, save it to a String
create a new Customer, using the constructor with both username and pin as the parameters
add that customer to the customers ArrayList
```

public void applyInterest()
```
for every Customer in customers
    call their savings account's calcInterest() method
```

public void loadSampleCustomers()  
```
create several sample customers and save them to the customers ArrayList
```

public void saveCustomers()  
```
create a new FileOutputStream called fo, set it to output to a file named "Customers.dat"
create a new ObjectOutputStream called obIn, set it to output to fo stream
use obIn to write the customers ArrayList out to a file
close both the fo and obIn streams
```

public void loadCustomers()  
```
create a new FileInputStream called fIn, have it read from "Customers.dat"
create a new ObjectInputStream called obIn, have it read from the fIn stream
create a new customer ArrayList by using obIn's readObject() method and save this value to customers
close both the fIn and obIn streams
```
