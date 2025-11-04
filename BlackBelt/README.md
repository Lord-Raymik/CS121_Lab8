# Changes I plan on making
I want to try and modify the customer class somewha. Like the account and such works fine as is.  
If there is anythign specific I'm going to change, it will likely involve making customers have mutiple different accounts rather than just one checking and savings account. As for how I will do this, I will make the option to open the checking account call a different method, which itself will ask the user to select an account to access. This will only need me to swap out like a few lines in the actual running algorithm, though I will need to write some new methods. Either way though, it should work fairly well.  

## Select Account Method
This method will take in an arraylist as a parameter. it will then iterate through the arraylist printing each available account to the user, before askign them to select one. after one is selected, it will call start on the selected account.  

### Algorithm
```
create a new scanner called input
tell the user to select an account
for arraylist.size() times (i is the control variable)
    print the term "Account" with the current i value after it
use input to ask the user what account to select, save this to a string variable called response
if response corresponds to a valid account
    call start() on the account
if response is not a valid account input
    tell the user it is an invalid account input
```
