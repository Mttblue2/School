import java.util.Random;
import java.util.Scanner;

public class Random_Lab
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      Random random = new Random();
      
      System.out.println("Please enter your first and last name.");
      String name = keyboard.nextLine();
      
      int space = name.indexOf(" ");
      int last_initial_start = space + 1;
      int last_initial_end = last_initial_start + 1;
      String initials = name.substring(0,1).toUpperCase() + ". " + 
                        name.substring(last_initial_start, last_initial_end).toUpperCase()+ ".";
      
      System.out.println("Your Initials are: " + initials);
      System.out.println(); 
      System.out.println("Here is a random number: " + random.nextInt());
      System.out.println("Here is a random number between 0 and 50: " + random.nextInt(51));
      System.out.println("Here is a random number between -10 and 26: " + (random.nextInt(36) - 10));
      System.out.println();
      
      System.out.println("Please enter your first integer.");
      int first_number = keyboard.nextInt();
      System.out.println("Please enter your second integer.");
      int second_number = keyboard.nextInt();
      
      if (first_number < second_number)
      {
         int temp = first_number;
         first_number = second_number;
         second_number = temp;
      }
      
      System.out.println("Here is a random number between your values: " + 
                           (random.nextInt(first_number - second_number) + second_number));
      System.out.println();
      System.out.println("Here is a random float: " + random.nextFloat());
      System.out.println("Here is a random float between 2 and 10: " + (random.nextFloat()*8)+2);
      System.out.println("Here is a random boolean: " + random.nextBoolean());
      System.out.println("On the coin flip, you got: " + "HT".charAt(random.nextInt(2)));
      System.out.println("Here is a random character from the alphabet: " +
                         "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(26)));
   }
}