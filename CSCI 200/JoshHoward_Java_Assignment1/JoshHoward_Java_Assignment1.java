/****************************************************************
   Program:     JoshHoward_Java_Assignment1.java
   Course Info: CSCI: 200, section 002
   Author:      Josh Howard
   Date:        02/10/2016
   Description: calulates total area of a yard and cutting time,
                then prints a receipt with total area, time and
                amount to be paid
****************************************************************/

public class JoshHoward_Java_Assignment1
{
   public static void main(String[] args)
   {
      //defines constant rates and defines area for yard, driveway and house. Also convertion factors
      final double CUT_RATE_MPS = 2.56, RATE_PER_HOUR = 21.35;
      double lot_area_acres = 4.52, house_area_sqft = 43 * 81, driveway_area_sqft = 8 * 14;
      double acre_to_sqm = 4046.856, sqft_to_sqm = .093025, to_minutes = 60, to_hours = 60;
      
      //converts everything to square meters and all of the calculations
      double lot_area_sqm = lot_area_acres * acre_to_sqm, house_area_sqm = house_area_sqft * sqft_to_sqm, driveway_area_sqm = driveway_area_sqft * sqft_to_sqm;
      double area_not_cut = house_area_sqm + driveway_area_sqm, yardage_mowed = lot_area_sqm - area_not_cut;
      double total_time = yardage_mowed / (CUT_RATE_MPS * to_minutes), payment_due = (total_time / to_hours) * RATE_PER_HOUR;
      
      //prints receipt
      System.out.println("|=========================|");
      System.out.println("|        J's Mowing       |");
      System.out.println("|=========================|");
      System.out.println("We'll make your grass troubles go away!");
      System.out.println();
      System.out.println("Total yardage:           " + lot_area_sqm + " square meters");
      System.out.println("Yardage mowed:           " + yardage_mowed + " square meters");
      System.out.println("Total time of service:   " + total_time + " minutes");
      System.out.println();
      System.out.println("At a payment rate of $" + RATE_PER_HOUR + " an hour for this service," + 
                         "\n\tthe paymentdue is around $" + (int)(payment_due) + ".");
   }
}