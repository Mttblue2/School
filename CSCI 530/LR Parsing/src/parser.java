import java.util.Scanner;

public class parser
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		String[][] action = {
				{"s5", null, null, "s4", null, null},
				{null, "s6", null, null, null, "acc"},
				{null, "r2", "s7", null, "r2", "r2"},
				{null, "r4", "r4", null, "r4", "r4"},
				{"s5", null, null, "s4", null, null},
				{null, "r6", "r6", null, "r6", "r6"},
				{"s5", null, null, "s4", null, null},
				{"s5", null, null, "s5", null, null},
				{null, "s6", null, null, "s11", null},
				{null, "r1", "s7", null, "r1", "r1"},
				{null, "r3", "r3", null, "r3", "r3"},
				{null, "r5", "r5", null, "r5", "r5"}
		};
		
		int[][] go_to = {
				{1,2,3},
				{8, 2, 3},
				{0, 9, 3},
				{0, 0, 10}
		};
		
		try
		{
			
			System.out.print("Please enter your sentence to parse: ");
			
			StringBuilder sentense = new StringBuilder(kb.nextLine());
			
			System.out.println(sentense);
			
		} catch (Exception e)
		{
			System.out.println("Error: " + e);
		} finally
		{
			kb.close();
		}

	}

}
