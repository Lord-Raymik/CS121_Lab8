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
