import java.util.Scanner;

public class Cat_Driver
{
   
   public static void main(String[] args)
   {  
      Scanner keyboard = new Scanner(System.in);
      int x = 0;
   
      System.out.println("What is your cats name?");
      String name = keyboard.next();
      System.out.println("What is the weight of your cat? (Whole Number Weight)");
      int weight = keyboard.nextInt();
      
      while (weight < 1)
      {
         System.out.println("Your cat has to exist... Please reenter...");
         weight = keyboard.nextInt();
      }
      
      Cat cat1 = new Cat(name, weight);
      
      System.out.println("Type help for commands");
      System.out.println();
      
      while (x < 1)
      {
         System.out.println("What would you like to do?");
         String command = keyboard.next();
         
         command = command.toLowerCase();
        
         if (command.equals("pet"))
            cat1.Pet();
         
         else if (command.equals("eat"))
            cat1.Eat();
         
         else if (command.equals("poop"))
            cat1.Poop();
         
         else if (command.equals("kick"))
            cat1.Kick();
            
         else if (command.equals("done"))
            x++;
            
         else if (command.equals("help"))
            System.out.println("pet, eat, poop, kick, kill, done");
            
         else if (command.equals("kill"))
         {
            System.out.println("Your a terrible person...");
            cat1 = null;
            System.out.println("Your cat is now dead...");
            break;
         }
         
         System.out.println(cat1);
         System.out.println();
      }
      
   
      /*Cat tabby1 = new Cat();
      Cat tabby2 = new Cat(15, "PURRR");
      
      System.out.println(tabby1);
      System.out.println(tabby2);
      System.out.println();
      
      tabby1.Eat();
      tabby2.Poop();
      tabby1.Pet();
      tabby2.Kick();
      
      System.out.println(tabby1);
      System.out.println(tabby2);
      System.out.println();
      
      tabby1.setWeight(24);
      tabby2.setMood("QUIET");
      
      System.out.println("Weight of tabby 1: " + tabby1.getWeight());
      System.out.println("Mood of tabby 2: " + tabby2.getMood());*/
   }
   
}