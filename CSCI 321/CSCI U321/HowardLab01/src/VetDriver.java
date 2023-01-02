import java.util.Scanner;


public class VetDriver 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Vet v = new Vet("Lakeside Clinic", 20);
		
		//------------------------ Filling Some Data ----------------------------------
		//---- Notice how I can initialize Pet to be objects of Pet or any COMPATIBLE type -----
		Pet pArray[] = { new Pet("Zoey", "Mr. Ed", 100),
						 new Dog("Fido", "John", 50, "small"),
						 new Cat("Fluffy", "Susie", 10, true),
						 new Dog("Kira", "Patrick", 70, "large"),
						 new Cat("Mugsy", "Phil", 12, false) };
		
		for (Pet p: pArray)
		{
			v.add(p);
		}
		
		
		Scanner scan = new Scanner(System.in);
		
		//------------------------ Testing Display --------------------------------------
		v.display();
		
		//------------------------ Testing Visit Method --------------------------------
		pArray[0].visit(1);
		pArray[1].visit(2);
		pArray[2].visit(3);
		pArray[0].visit(3);
		pArray[1].visit(2);
		pArray[2].visit(1);
		pArray[3].visit(1);
		pArray[4].visit(0);
		
		//------------------------ Testing Display --------------------------------------
		System.out.println();
		v.display();		
		
		//------------------------ Testing Find --------------------------------------
		System.out.println("\nPlease enter the name of the pet you would like to find: ");
		String name = scan.next();
		Pet pFind = v.find(name);
		if (pFind != null)
		{
			System.out.println(pFind);
		}
		else
		{
			System.out.println("Pet not found.");
		}
		
		//------------------------ Testing Delete ------------------------------------
		System.out.println("\nPlease enter the name of the pet you would like to delete: ");
		String nameD = scan.next();
		Pet pDel = v.find(nameD);
		if (pDel != null)
		{			
			v.delete(pDel);		
		}
		else
		{
			System.out.println("Pet not found.");
		}
		
		//------------------------ Testing Delete ------------------------------------
		System.out.println("\nPlease enter the name of the pet you would like to delete: ");
		String nameD2 = scan.next();
		Pet pDel2 = v.find(nameD2);
		if (pDel2 != null)
		{
			v.delete(pDel2);
		}
		else
		{
			System.out.println("Pet not found.");
		}
		
		//------------------------ Testing Display to Confirm Delete -----------------
		System.out.println();
		v.display();
		
		
		scan.close();
		
		

	}

}
