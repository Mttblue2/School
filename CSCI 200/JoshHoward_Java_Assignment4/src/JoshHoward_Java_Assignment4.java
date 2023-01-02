/****************************************************************
   Program:     Point.java
   Course Info: CSCI: 200, section 002
   Author:      Josh Howard
   Date:        04/21/2016
   Description: A) Generates a user input sized boolean and int array,
                   calculates and displays arrays and data on them.
                B) Displays a vertical letter-frequency graph of a 
                   user input phrase
*****************************************************************/
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class JoshHoward_Java_Assignment4 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		DecimalFormat deci_format = new DecimalFormat("0.000");
		
		//creates needed variable
		int boolean_f = 0,boolean_t = 0,total = 0,odd_total = 0,index = -1;
		String odd_numbers = "";
		
		//Gets a size of array from user and verifies non-negative array
		System.out.print("Welcome to Randomly Generated Array Values Program!" +
		                   "\nPlease enter the number of elements for both arrays: ");
	    int num_array = keyboard.nextInt();
	    
	    while (num_array <= 0)
	    {
	    	System.out.print("Error: Number must be positive" + "\nPlease reenter: ");
	    	num_array = keyboard.nextInt();
	    }
	    keyboard.nextLine();
	    
	    //creates user input sized arrays
	    int[] numbers = new int[num_array];
	    boolean[] true_false = new boolean[num_array];
	    
	    //fills arrays with random booleans
	    //also gathers boolean data
	    for(int x=0;x < num_array;x++)
	    {
	    	true_false[x] = random.nextBoolean();
	    	
	    	if (true_false[x] == true)
	    	{
	    		boolean_t++;
	    		if (index == -1)
	    			index = x;
	    	}
	    	else if (true_false[x] == false)
	    		boolean_f++;
	    }
	    
	    //fills arrays with random ints
	    //also gathers int data
	    for(int x=0;x < num_array;x++)
	    {
	       numbers[x] = (random.nextInt(10)-5);
	       
	       if ((numbers[x]%2) != 0)
	       {
	    	   odd_total++;
	    	   
	    	   if (x == (num_array-1))
	    		   odd_numbers = odd_numbers + Integer.toString(numbers[x]);
	    	   else
	    		   odd_numbers = odd_numbers + Integer.toString(numbers[x]) + ", ";
	       }
	       total = total + numbers[x];
	    }
	    
	    //prints to user the arrays and info about them
	    System.out.println("Boolean Array Contents:");
	    for(int x=0;x < num_array;x++)
	    {
	    	if (x < num_array-1)
	    		System.out.print(true_false[x] + ", ");
	    	else
	    		System.out.print(true_false[x]);
	    }
	    System.out.println("\n\tTotal TRUEs: " + boolean_t);
	    System.out.println("\tTotal FALSEs: " + boolean_f);
	    System.out.println("\tIndex of first TRUE: " + index);
	    
	    System.out.println("Integer Array contents:");
	    for(int x=0;x < num_array;x++)
	    {
	    	if(x < num_array-1)
	    		System.out.print(numbers[x] + ", ");
	    	else
	    		System.out.print(numbers[x]);
	    }
	    System.out.println("\n\tTotal odd number: " + odd_total);
	    System.out.println("\tOdd elements are: " + odd_numbers);
	    System.out.println("\tElement Mean is: " + deci_format.format((double)(num_array)/total));
	    
	    System.out.println("-----------------------------------------------------------");
	    
		//creates array for number of each character and needed variables
	    int[] number_of_chars = new int[26];
	    int y = 65,largest_num = 0;
	    
	    //requests a phrase and checks phrase length
	    System.out.println("Welcome to Super-D-Duper Letter Frequency Counter!" +
	                       "\nPlease enter a phrase that is no more than 60 characters:");
	    String phrase = keyboard.nextLine();
	      
	    while (phrase.length() > 60)
	    {
	    	System.out.println("\nError: Phrase exceeds 60 characters\n"+
	                           "Please reenter phrase:");
	    	phrase = keyboard.nextLine();
	    }
	    phrase = phrase.toUpperCase();
	    
	    System.out.println("The following is the Letter-Frequency graph:");
	    
	    //check and fills number_of_chars with the frequency of each letter
	    for (int x = 0;x < 26;x++)
	    {
	    	for (int z = 0;z < phrase.length(); z++)
	        {
	    		if (y == phrase.charAt(z))
	    			number_of_chars[x] = number_of_chars[x] + 1;
	        }
	    	if (number_of_chars[x] > largest_num)
	    		largest_num = number_of_chars[x];
	    	y++;
	    }
	    
	    //prints out a vertical letter-frequency graph of the given phrase
	    while (largest_num > 0)
	    {
	    	for (int x = 0;x <= 25;x++)
	    	{
	    		if (number_of_chars[x] == largest_num)
	    		{
	    			System.out.print("* ");
	    			number_of_chars[x]--;
	    		}
	    		else
	    			System.out.print("  ");
	    	}
	    	System.out.println();
	    	largest_num--;
	    }
	    
	    System.out.print("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n"+
	                     "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
	    
	}

}
