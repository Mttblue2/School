//************************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, and get a String representation
// of the account.
//************************************************************
import java.util.Random;

public class Account
{
   private double balance;
   private String name;
   private long acctNum;
   public static int numAccounts = 0;
   
   Random random = new Random();
   
//-------------------------------------------------
//Constructor -- initializes balance, owner, and account number
//-------------------------------------------------
   public Account(double initBal, String owner, long number)
   {
      balance = initBal;
      name = owner;
      acctNum = number;
      numAccounts++;
   }
   public Account (double initBal, String owner)
   {
      balance = initBal;
      name = owner;
      acctNum = random.nextInt(1000000)+1;
      numAccounts++;
   }
   public Account (String owner)
   {
      balance = 0;
      name = owner;
      acctNum = random.nextInt(1000000)+1;
      numAccounts++;
   }
//-------------------------------------------------
// Checks to see if balance is sufficient for withdrawal.
// If so, decrements balance by amount; if not, prints message.
//-------------------------------------------------
   public void withdraw(double amount)
   {
      if (balance >= amount)
      balance -= amount;
      else
      System.out.println("Insufficient funds");
   }
   public void withdraw(double amount, double fee)
   {
      balance -= fee;
      
      if (balance >= amount)
      balance -= amount;
      else
      System.out.println("Insufficient funds");
   }
//-------------------------------------------------
// Adds deposit amount to balance.
//-------------------------------------------------
    public void deposit(double amount)
    {
      balance += amount;
    }
//-------------------------------------------------
// Closes an account
//-------------------------------------------------
   public void close()
   {
      this.name = "CLOSED";
      this.balance = 0;
      numAccounts--;
   }
//-------------------------------------------------
// Returns balance.
//-------------------------------------------------
   public double getBalance()
   {
      return balance;
   }
//-------------------------------------------------
// Consolidates two accounts
//-------------------------------------------------
   public static Account consolidate(Account acct1, Account acct2)
   {
      if (acct1.name.equals(acct2.name))
      {
         if (acct1.acctNum != acct2.acctNum)
         {
            Account new_account = new Account(acct1.balance+acct2.balance,acct1.name);
            acct1.close();
            acct2.close();
            System.out.println("Account Consolidation Successful.");
            
            return new_account;
         }
         else
         {
            System.out.println("The two account's cannot be combined.");
            System.out.println("Reason: Accounts have the same Account Number.");
            
            return null;
         }
      }
      else
      {
         System.out.println("The two account's cannot be combined.");
         System.out.println("Reason: Accounts have different names.");
         
         return null;
      }
   }
//-------------------------------------------------
// Returns the number of accounts
//-------------------------------------------------
   public static int getNumAccounts()
   {
      return numAccounts;
   }
//-------------------------------------------------
// Returns a string containing the name, account number, and balance.
//-------------------------------------------------
   public String toString()
   {
      return "Name:" + name +
      "\nAccount Number: " + acctNum +
      "\nBalance: " + balance;
   }
}
