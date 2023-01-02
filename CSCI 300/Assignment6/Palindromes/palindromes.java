import java.util.Scanner;

public class palindromes
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Please enter your sentence.");
      String sentence = kb.nextLine();
      sentence = sentence.replaceAll(" ","");
      sentence = sentence.toLowerCase();
      
      if (palindrome(sentence) == true)
         System.out.println("Your sentence is a palindrome.");
      else
         System.out.println("Your sentence isn't a palindrome.");
   }
   
   public static boolean palindrome(String temp)
   {
      if (temp.length() == 1)
      {
         return true;
      }
      else if (temp.charAt(0) == temp.charAt(temp.length()-1) && temp.length() == 2)
      {
         return true;
      }
      else if (temp.charAt(0) == temp.charAt(temp.length()-1))
      {
         return palindrome(temp.substring(1,(temp.length()-1)));
      }
      else
      {
         return false;
      }
   }
}