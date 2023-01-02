/****************************************************************
   Program:     Account_Creations.java
   Course Info: CSCI: 300, section 002
   Author:      Josh Howard
   Date:        09/09/2017
   Description: Receives account inputs, closes one and
                consolidates the others.
****************************************************************/

import java.util.Scanner;

public class Account_Creations
{
   public static void main(String[] args)
   {
      //Creates scanner and 3 accounts
      Scanner keyboard = new Scanner(System.in);
      
      Account account1, account2, account3, account4;
      
      //Prompts for account names, initializes with the name and $100
      System.out.println("Please enter the name on the first account.");
      account1 = new Account(100, keyboard.nextLine());
      System.out.println("Please enter the name on the second account.");
      account2 = new Account(100, keyboard.nextLine());
      System.out.println("Please enter the name on the third account.");
      account3 = new Account(100, keyboard.nextLine());
      System.out.println("--------------------------");
      
      //Prints all three accounts
      System.out.println(account1.toString());
      System.out.println();
      System.out.println(account2.toString());
      System.out.println();
      System.out.println(account3.toString());
      System.out.println("--------------------------");
      
      //Closes first account
      account1.close();
      
      //Trys to consolidate second and third account
      account4 = Account.consolidate(account2, account3);
      System.out.println("--------------------------");
      
      //Prints all four accounts
      System.out.println(account1.toString());
      System.out.println();
      System.out.println(account2.toString());
      System.out.println();
      System.out.println(account3.toString());
      System.out.println();
      if (account4 != null)
         System.out.println(account4.toString());
   }
}