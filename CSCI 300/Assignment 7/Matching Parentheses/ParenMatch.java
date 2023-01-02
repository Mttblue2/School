// ********************************************************************
// ParenMatch.java
//
// Determines whether or not a string of characters contains
// matching left and right parentheses.
// ********************************************************************
import java.util.*;
import java.util.Scanner;

public class ParenMatch
{
   public static void main (String[] args)
   {
      int index = 0;
      
      Stack s = new Stack();
      String line; // the string of characters to be checked
      Scanner scan = new Scanner(System.in);
      
      System.out.println ("\nParenthesis Matching");
      System.out.print ("Enter a parenthesized expression: ");
      line = scan.nextLine();
      
      try 
      {
         // loop to process the line one character at a time
         for (int x = 0; x < line.length(); x++)
         {
            if (line.charAt(x) == '{')
               s.push("}");
            else if (line.charAt(x) == '}')
               s.pop();
            index++;
         }
         
         if (s.isEmpty())
         {
            System.out.println();
            System.out.println("Parentheses Match!");
         }
         else if (!s.isEmpty())
         {
            System.out.println();
            System.out.println("ERROR: Too many left parentheses");
         }
      }
      // print the results
      catch (EmptyStackException e)
      {
         System.out.println();
         System.out.println("ERROR: Too many right parentheses");
         System.out.println("At: " + line.substring(0,index) + "}");
      }
   }
}