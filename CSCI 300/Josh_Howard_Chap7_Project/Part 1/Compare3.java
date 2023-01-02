/****************************************************************
   Program:     Compare3.java
   Course Info: CSCI: 300, section 002
   Author:      Josh Howard
   Date:        09/09/2017
   Description: find the largest of a string and returns that
                string
****************************************************************/

public class Compare3
{
   public static Comparable largest (Comparable c1, Comparable c2, Comparable c3)
   {
      Comparable largest;
      
      if (c1.compareTo(c2) >= 0 && c1.compareTo(c3) >= 0)
         largest = c1;
         
      else if (c2.compareTo(c1) >= 0 && c2.compareTo(c3) >= 0)
         largest = c2;
         
      else
         largest = c3;
      
      return largest;
   }
}