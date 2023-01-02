public class CircleDriver
{
   public static void main(String[] args)
   {
      Circle cir1 = new Circle();
      Circle cir2 = new Circle(3.0);
      Circle cir3 = new Circle(7.4, "blue");
      
      System.out.println(cir1);
      System.out.println(cir2);
      System.out.println(cir3);
      System.out.println();
      
      cir2.setColor("green");
      System.out.println("Radius of circle3: " + cir3.getRadius() + ". Area of circle3: " +
                         cir3.computeArea());
      System.out.println();
      
      System.out.println(cir1);
      System.out.println(cir2);
      System.out.println(cir3);
   }
}
