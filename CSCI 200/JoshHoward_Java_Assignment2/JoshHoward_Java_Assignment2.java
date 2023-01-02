/****************************************************************
   Program:     JoshHoward_Java_Assignment2.java
   Course Info: CSCI: 200, section 002
   Author:      Josh Howard
   Date:        03/4/2016
   Description: Welcomes the user by entered name and number, gives
                todays today and other specific dates and calculates
                a boyscout travels.
****************************************************************/
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Point;
import java.text.DecimalFormat;

public class JoshHoward_Java_Assignment2
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      DecimalFormat decimal_4 = new DecimalFormat(".0000");
      
      //Gets Name and Lucky Number from user. Then prints a welcome statement with the info
      System.out.print("Please enter your lucky number: ");
      int lucky_number = keyboard.nextInt();
      System.out.print("Please enter your first name: ");
      String first_name = keyboard.next();
      System.out.print("Please enter your last name: ");
      String last_name = keyboard.next();
      
      System.out.println("Welcome " + last_name + ", " + first_name + "! Your lucky number was " + lucky_number + ".");
      
      System.out.println();
      System.out.println("---------------------------------------------");
      System.out.println();
      
      //Makes two Calendar objects. One for the current date and one for Alan Turings Birthday.
      GregorianCalendar today_date = new GregorianCalendar();
      GregorianCalendar turing_bday = new GregorianCalendar(1912, Calendar.JUNE, 23);
      String weekdays = "SunMonTueWedThuFriSat";
      
      /*Calculates and Prints, 1:Todays date, 2:Current Weekday, 3:Date 100 days from now, 4:Is it a leap year, 
      5:Turings Birthday, 6:Weekday of Turings Birthday, 7:Date 35,502 from his birthday*/
      System.out.println("1.: " + (today_date.get(Calendar.MONTH)+1) + "-" + today_date.get(Calendar.DAY_OF_MONTH) + "-" + today_date.get(Calendar.YEAR));
      System.out.println("2.: " + weekdays.substring(today_date.get(Calendar.DAY_OF_WEEK)*3-3,today_date.get(Calendar.DAY_OF_WEEK)*3));
      today_date.add(Calendar.DAY_OF_MONTH, 100);
      System.out.println("3.: " + (today_date.get(Calendar.MONTH)+1) + "-" + today_date.get(Calendar.DAY_OF_MONTH) + "-" + today_date.get(Calendar.YEAR));
      System.out.println("4.: " + (today_date.isLeapYear(today_date.get(Calendar.YEAR))));
      System.out.println("5.: " + (turing_bday.get(Calendar.MONTH)+1) + "-" + turing_bday.get(Calendar.DAY_OF_MONTH) + "-" + turing_bday.get(Calendar.YEAR));
      System.out.println("6.: " + weekdays.substring(turing_bday.get(Calendar.DAY_OF_WEEK)*3-3,turing_bday.get(Calendar.DAY_OF_WEEK)*3));
      turing_bday.add(Calendar.DAY_OF_MONTH, 35502);
      System.out.println("7.: " + (turing_bday.get(Calendar.MONTH)+1) + "-" + turing_bday.get(Calendar.DAY_OF_MONTH) + "-" + turing_bday.get(Calendar.YEAR));
      
      System.out.println();
      System.out.println("---------------------------------------------");
      System.out.println();
      
      //Sets main points of the boy scout
      Point starting_location = new Point(-4, 5);
      Point HQ_location = new Point(10, 10);
      Point final_location = new Point();
      Point temp = new Point();
      
      //Calculates the final location, final distance and distance from HQ
      temp.setLocation((starting_location.getX() + 15*Math.cos(Math.toRadians(45))), (starting_location.getY() + 15*Math.sin(Math.toRadians(45))));
      temp.setLocation((temp.getX() + 10*Math.cos(Math.toRadians(135))), (temp.getY() + 10*Math.sin(Math.toRadians(135))));
      temp.setLocation((temp.getX() + 12*Math.cos(Math.toRadians(270))), (temp.getY() + 12*Math.sin(Math.toRadians(270))));
      final_location.setLocation((temp.getX() + 13*Math.cos(Math.toRadians(180))), (temp.getY() + 13*Math.sin(Math.toRadians(180))));
      double final_distance = Math.sqrt((Math.pow(final_location.getX() - starting_location.getX(), 2) + Math.pow(final_location.getY() - starting_location.getY(), 2 )));
      double distance_from_HQ = Math.sqrt((Math.pow(HQ_location.getX() - final_location.getX(), 2) + Math.pow(HQ_location.getY() - final_location.getY(), 2 )));
      
      //Prints out the information about the boy scout
      System.out.println("The Boy Scout started at location " + starting_location.toString().substring(14) + " and,\n\tafter traveling a distance of " +
                       decimal_4.format(final_distance) + " miles,\n\tended up at location " + final_location.toString().substring(14));
      System.out.println("The scout is a distance of " + decimal_4.format(distance_from_HQ) + " miles from the Headquarters.");
      }
}