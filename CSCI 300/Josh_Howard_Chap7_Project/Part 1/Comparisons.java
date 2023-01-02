/****************************************************************
   Program:     Comparisons.java
   Course Info: CSCI: 300, section 002
   Author:      Josh Howard
   Date:        09/09/2017
   Description: Receives 3 string inputs and outputs the largest
                to the user, then 3 number's and outputs the 
                largest.
****************************************************************/

import java.util.Scanner;

public class Comparisons
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Please enter 3 strings");
      String string1 = keyboard.nextLine();
      String string2 = keyboard.nextLine();
      String string3 = keyboard.nextLine();
      
      System.out.print("Here is the largest of your strings: ");
      System.out.println(Compare3.largest(string1,string2,string3));
      System.out.println();
      
      System.out.println("Please enter 3 integers");
      int number1 = keyboard.nextInt();
      int number2 = keyboard.nextInt();
      int number3 = keyboard.nextInt();
      
      System.out.print("Here is the largest of your numbers: ");
      System.out.println(Compare3.largest(number1,number2,number3));
   }
   
}