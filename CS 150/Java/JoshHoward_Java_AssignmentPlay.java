/****************************************************************
   Program:     JoshHoward_Java_Assignment.java
   Course Info: CSCI: 150, section 003
   Author:      Josh Howard
   Date:        11/30/2015
   Description: This program calculates the area and 
                the circumference of a circle with radius 15.
****************************************************************/

public class JoshHoward_Java_AssignmentPlay
{
   public static void main(String[] args)
   {
      int x=1;
      //prints to the user a description block and the results of calculations
      System.out.println("==============================================");
      System.out.println("*   Project Name:  Java Assignment           *");
      System.out.println("*          Class:  CSCI 150, Section 003     *");
      System.out.println("*         Author:  Josh Howard               *");
      System.out.println("*       Due Date:  Friday, December 4        *");
      System.out.println("==============================================");
      System.out.println("");
      
      while (x<=1000)
      {
         //inputs a radius and calculates area and circumference
         double radius = x;
         double area = Math.PI * Math.pow(radius, 2);
         double circumference = 2 * Math.PI * radius;
         System.out.println("Circle wih radius of " + x + " calculation results:");
         System.out.println("     Area is " + area);
         System.out.println("     Circumference is " + circumference);
         System.out.println("");
         x=x+1;
      }
   }
}