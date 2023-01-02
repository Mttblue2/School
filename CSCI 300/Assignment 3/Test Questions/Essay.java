import java.util.Scanner;

public class Essay extends TestQuestion
{
   private int blankLines;
   
   public void readQuestion(Scanner scan)
   {
      blankLines = scan.nextInt();
      testQuestion = scan.next() + scan.nextLine();
   }
   public String toString()
   {
      String temp = (testQuestion);
      
      for (int x=0;x<blankLines;x++)
         temp = temp + "\n";
      
      return temp;
   }
}