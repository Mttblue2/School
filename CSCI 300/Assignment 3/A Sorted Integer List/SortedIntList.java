public class SortedIntList extends IntList
{
   //-------------------------------------------------------------
   // Constructor -- creates an integer list of a given size.
   //-------------------------------------------------------------
   public SortedIntList(int size)
   {
      super(size);
   }
   
   //------------------------------------------------------------
   // Adds an integer to the list. If the list is full,
   // prints a message and does nothing.
   //------------------------------------------------------------
   public void add(int value)
   {
      int x=numElements,y=0;
      
      if (numElements == list.length)
         System.out.println("Can't add, list is full");
      else
      {
         if (numElements == 0)
         {
            list[0] = value;
         }
         else
         {
            while (value>list[y])
            {
               y++;
               if (list[y]==0)
               {
                  list[y]=value;
                  break;
               }
            }
            while (x>=y)
            {
               list[x+1]=list[x];
               x--;
            }
            list[y]=value;
         }
         numElements++;
      }
   }
   
   //-------------------------------------------------------------
   // Returns a string containing the elements of the list with their
   // indices.
   //-------------------------------------------------------------
   public String toString()
   {
      String returnString = "";
      for (int i=0; i<numElements; i++)
         returnString += i + ": " + list[i] + "\n";
      return returnString;
   }
}