public class Circle
{
   private double radius;
   private String color;
   
   public Circle()
   {
      radius = 1.0;
      color = "red";
   }
   public Circle(double newR)
   {
      radius = newR;
      color = "red";
   }
   public Circle(double newR, String newC)
   {
      radius = newR;
      color = newC;
   }
   
   public double getRadius()
   {
      return radius;
   }
   public double computeArea()
   {
      double area = Math.PI*(radius*radius);
      return area;
   }
   public void setColor(String newC)
   {
      color = newC;
   }
   public String toString()
   {
      return "\tThe " + color + " circle has a radius of " + radius + " and an area of " +
             Math.PI*(radius*radius) + ".";
   }
}