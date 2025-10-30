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


