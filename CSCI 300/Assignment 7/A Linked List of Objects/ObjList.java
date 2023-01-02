// ***************************************************************
// FILE: IntList.java
//
// Purpose: Defines a class that represents a list of integers
//
// ***************************************************************
public class ObjList
{
   private ObjNode front; //first node in list
//-----------------------------------------
// Constructor. Initially list is empty.
//-----------------------------------------
   public ObjList()
   {
      front = null;
   }
//-----------------------------------------
// Adds given string to front of list.
//-----------------------------------------
   public void addToFront(Object obj)
   {
      front = new ObjNode(obj,front);
   }
//-----------------------------------------
// Adds given integer to end of list.
//-----------------------------------------
   public void addToEnd(Object obj)
   {
      ObjNode newnode = new ObjNode(obj,null);
      //if list is empty, this will be the only node in it
      if (front == null)
            front = newnode;
      else
      {
      //make temp point to last thing in list
         ObjNode temp = front;
         while (temp.next != null)
            temp = temp.next;
      //link new node into list
         temp.next = newnode;
      }
   }
//-----------------------------------------
// Removes the first node from the list.
// If the list is empty, does nothing.
//-----------------------------------------
   public void removeFirst()
   {
      if (front != null)
         front = front.next;
   }
//------------------------------------------------
// Prints the list elements from first to last.
//------------------------------------------------
   public void print()
   {
      System.out.println("--------------------");
      System.out.print("List elements: ");
      ObjNode temp = front;
      while (temp != null)
      {
         System.out.print(temp.object + " ");
         temp = temp.next;
      }
      System.out.println("\n-----------------------\n");
   }
//*************************************************************
// An inner class that represents a node in the object list.
// The public variables are accessed by the ObjList class.
//*************************************************************
   private class ObjNode
   {
      public Object object; //object stored in node
      public ObjNode next; //link to next node in list
//------------------------------------------------------------------
// Constructor; sets up the node given a value and ObjNode reference
//------------------------------------------------------------------
      public ObjNode(Object object, ObjNode next)
      {
         this.object = object;
         this.next = next;
      }
   }
}