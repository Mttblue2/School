/****************************************************************
   Program:     JoshHoward_Java_Assignment2.java
   Course Info: CSCI: 200, section 002
   Author:      Josh Howard
   Date:        04/1/2016
   Description: Creates an Triangle object with 2 points
****************************************************************/
public class Triangle 
{
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;

    //-----------------------------------------------------------------
    //  Constructor: Sets points of Triangle with six Xs and six Ys
    //-----------------------------------------------------------------
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) 
    {
        vertex1 = new Point(x1, y1);
        vertex2 = new Point(x2, y2);
        vertex3 = new Point(x3, y3);
    }

    //-----------------------------------------------------------------
    //  Constructor: Sets points of Triangle with 3 point objects
    //-----------------------------------------------------------------
    public Triangle(Point v1, Point v2, Point v3) 
    {
        vertex1 = v1;
        vertex2 = v2;
        vertex3 = v3;
    }

    //-----------------------------------------------------------------
    //  Calculates and returns the perimeter
    //-----------------------------------------------------------------
    public double getPerimeter() 
    {
        return vertex1.distance(vertex2) + vertex2.distance(vertex3) + vertex3.distance(vertex1);
    }

    //-----------------------------------------------------------------
    //  Calculates and returns the area
    //-----------------------------------------------------------------
    public double calculateArea() 
    {
        double p = getPerimeter() / 2.0;
        double a = vertex1.distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(vertex1);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    //-----------------------------------------------------------------
    //  Moves Triangle a given X and Y distance and returns a new triangle
    //-----------------------------------------------------------------
    public Triangle translate(int xDir, int yDir) 
    {
        Point temp_p1 = vertex1.translate(xDir, yDir);
        Point temp_p2 = vertex2.translate(xDir, yDir);
        Point temp_p3 = vertex3.translate(xDir, yDir);
        Triangle temp_Tri = new Triangle(temp_p1, temp_p2, temp_p3);
        
        return temp_Tri;
    }

    //-----------------------------------------------------------------
    //  Rotates Triangle around a given point a given degrees and return
    //  a new Triangle 
    //-----------------------------------------------------------------
    public Triangle rotate(Point pt, double angle) 
    {
        Triangle temp_Tri = translate(- pt.getX(), - pt.getY());
        
        Point temp1 = new Point((int)((double)temp_Tri.vertex1.getX() * Math.cos(Math.toRadians(angle)) - (double)temp_Tri.vertex1.getY() * Math.sin(Math.toRadians(angle))), (int)((double)temp_Tri.vertex1.getY() * Math.cos(Math.toRadians(angle)) + (double)temp_Tri.vertex1.getX() * Math.sin(Math.toRadians(angle))));
        Point temp2 = new Point((int)((double)temp_Tri.vertex2.getX() * Math.cos(Math.toRadians(angle)) - (double)temp_Tri.vertex2.getY() * Math.sin(Math.toRadians(angle))), (int)((double)temp_Tri.vertex2.getY() * Math.cos(Math.toRadians(angle)) + (double)temp_Tri.vertex2.getX() * Math.sin(Math.toRadians(angle))));
        Point temp3 = new Point((int)((double)temp_Tri.vertex3.getX() * Math.cos(Math.toRadians(angle)) - (double)temp_Tri.vertex3.getY() * Math.sin(Math.toRadians(angle))), (int)((double)temp_Tri.vertex3.getY() * Math.cos(Math.toRadians(angle)) + (double)temp_Tri.vertex3.getX() * Math.sin(Math.toRadians(angle))));
        Triangle new_triangle = new Triangle(temp1, temp2, temp3);
        temp_Tri = new_triangle.translate(pt.getX(), pt.getY());
        
        return temp_Tri;
    }

    //-----------------------------------------------------------------
    //  Calculates and returns Triangle type
    //-----------------------------------------------------------------
    public String getType() 
    {
        double side1 = vertex1.distance(vertex2);
        double side2 = vertex2.distance(vertex3);
        double side3 = vertex3.distance(vertex1);
        
        if (side1 == side2 && side2 == side3) 
            return "Equilateral Triangle";
            
        else if (side1 == side2 || side2 == side3 || side3 == side1) 
            return "Isosceles triangle";
            
        else return "Scalene Triangle";
    }

    //-----------------------------------------------------------------
    //  toString: returns a sting representation of the Triangle
    //-----------------------------------------------------------------
    public String toString() 
    {
        return "Triangle @ " + vertex1 + ", " + vertex2 + ", " + vertex3 + ".";
    }
}
