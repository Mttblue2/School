import java.util.Scanner;

public class MultChoice extends TestQuestion
{
   private int numChoices;
   private String choices;
   
   public void readQuestion(Scanner scan)
   {
      int letter = 97;
      numChoices = scan.nextInt();
      testQuestion = scan.next() + scan.nextLine();
      choices = "   " + (char)letter + ") ";
      letter++;
      
      for (int x=0;x<numChoices;x++)
      {
         choices = choices + scan.next() + "\n";
         if (x != numChoices-1)
            choices = choices + "   " + (char)letter + ") ";
         letter++;
      }
   }
   
   public String toString()
   {
      String temp = testQuestion + "\n" + choices;
      return temp;
   }
}