// ************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ************************************************************************
import java.util.Scanner;
import java.io.*;
public class Warning
{
// -------------------------------------------------------------------
// Reads student data (name, semester hours, quality points) from a
// text file, computes the GPA, then writes data to another file
// if the student is placed on academic warning.
// -------------------------------------------------------------------
   public static void main (String[] args)
   {
      int creditHrs; // number of semester hours earned
      double qualityPts; // number of quality points earned
      double gpa; // grade point (quality point) average
      
      String temp, line, name, inputName = "students.dat";
      String outputName = "warning.dat";
      try
      {
         Scanner file = new Scanner(new File("students")); // Set up scanner to input file
         FileWriter writeFile = new FileWriter("students warning");
         PrintWriter outFile = new PrintWriter(writeFile);// Set up the output file stream
         
         // Print a header to the output file
         outFile.println();
         outFile.println("Students on Academic Warning");
         outFile.println();
         
         // Process the input file, one token at a time
         while (file.hasNextLine())
         {
            // Get the credit hours and quality points and
            // determine if the student is on warning. If so,
            // write the student data to the output file.
            line = file.nextLine();
            Scanner scanline = new Scanner(line);
            
            name = scanline.next();
            
            temp = scanline.next();
            creditHrs = Integer.parseInt(temp);
            
            temp = scanline.next();
            qualityPts = Double.parseDouble(temp);
            
            gpa = qualityPts/creditHrs;
            
            if (gpa < 1.5 && creditHrs < 30)
               outFile.println(name + " " + creditHrs + " " + gpa);
            else if (gpa < 1.75 && creditHrs < 60)
               outFile.println(name + " " + creditHrs + " " + gpa);
            else if (gpa < 2)
               outFile.println(name + " " + creditHrs + " " + gpa);
         }
         // Close output file
         outFile.close();
      }
      catch (FileNotFoundException exception)
      {
         System.out.println ("The file " + inputName + " was not found.");
      }
      catch (IOException exception)
      {
         System.out.println (exception);
      }
      catch (NumberFormatException e)
      {
         System.out.println ("Format error in input file: " + e);
      }
   }
}