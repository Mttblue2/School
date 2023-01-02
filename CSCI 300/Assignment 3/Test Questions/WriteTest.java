import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WriteTest
{
   public static void main(String[] args) throws IOException
   {
      Scanner scan = new Scanner(new File("testbank"));
      int numQuestions = scan.nextInt();
      int y = 0;
      TestQuestion[] test = new TestQuestion[numQuestions];
      
      while (y < numQuestions)
      {
         
        if (scan.next().equals("e"))
        {
            test[y] = new Essay();
            test[y].readQuestion(scan);
        }
        else
        {   
            test[y] = new MultChoice();
            test[y].readQuestion(scan);
        }
        y++;
      }
      y=0;
      
      while (y < numQuestions)
      {
         System.out.println((y+1) + ". " + test[y].toString());
         System.out.println("=================");
         y++;
      }

   }
}