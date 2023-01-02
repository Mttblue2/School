/****************************************************************
   Program:     Point.java
   Course Info: CSCI: 200, section 002
   Author:      Josh Howard
   Date:        04/1/2016
   Description: Creates a Point object with an X and Y
*****************************************************************/
public class Point 
{
    private int x;
    private int y;

    //-----------------------------------------------------------------
    //  Constructor: Sets the default X and Y values
    //-----------------------------------------------------------------
    public Point() 
    {
        x = 0;
        y = 0;
    }
    
    //-----------------------------------------------------------------
    //  Constructor: Sets the X and Y from given values
    //-----------------------------------------------------------------
    public Point(int temp_x, int temp_y) 
    {
        x = temp_x;
        y = temp_y;
    }

    //-----------------------------------------------------------------
    //  Calculates and returns the distance between two points
    //-----------------------------------------------------------------
    public double distance(Point temp) 
    {
        double distance = Math.sqrt(Math.pow(temp.getX() - x, 2.0) + Math.pow(temp.getY() - y, 2.0));
        return distance;
    }

    //-----------------------------------------------------------------
    //  Moves a point with a given X and Y direction
    //-----------------------------------------------------------------
    public Point translate(int temp_x, int temp_y) 
    {
        Point new_point = new Point(x + temp_x, y + temp_y);
        return new_point;
    }

    //-----------------------------------------------------------------
    //  Accessor: Gets X value
    //-----------------------------------------------------------------
    public int getX() 
    {
        return x;
    }

    //-----------------------------------------------------------------
    //  Accessor: Gets Y value
    //-----------------------------------------------------------------
    public int getY() 
    {
        return y;
    }

    //-----------------------------------------------------------------
    //  Mutator: Sets X to a given value
    //-----------------------------------------------------------------
    public void setX(int temp_x) 
    {
        x = temp_x;
    }

    //-----------------------------------------------------------------
    //  Mutator: Sets Y to a given value
    //-----------------------------------------------------------------
    public void setY(int temp_y) 
    {
        y = temp_y;
    }

    //-----------------------------------------------------------------
    //  Mutator: Sets X and Y to a given value
    //-----------------------------------------------------------------
    public void setXY(int temp_x, int temp_y) 
    {
        x = temp_x;
        y = temp_y;
    }

    //-----------------------------------------------------------------
    //  toString: returns a sting representation of the point
    //-----------------------------------------------------------------
    public String toString() 
    {
        return "(" + this.x + ", " + this.y + ")";
    }
}
