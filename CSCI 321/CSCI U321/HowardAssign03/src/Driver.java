import java.io.File;
import java.util.Scanner;

public class Driver
{

	public static void main(String[] args)
	{
		String inFilename = "graph2.txt";
		String inFilename2 = "check2.txt";

		Scanner input_stream = null;
		Scanner input_stream2 = null;
		Scanner current_line = null;
		Scanner vertex_check = null;

		try
		{
			input_stream = new Scanner(new File(inFilename));
			input_stream2 = new Scanner(new File(inFilename2));

			String num_edges = input_stream.nextLine();
			int x = Integer.parseInt(num_edges);
			int y = 0;

			Graph graph = new Graph(x);

			while (input_stream.hasNextLine())
			{
				current_line = new Scanner(input_stream.nextLine());

				for (int z = 0; z < x; z++)
				{
					graph.addEdge(y, z, current_line.nextInt());
				}
				y++;
			}

			while (input_stream2.hasNextLine())
			{
				vertex_check = new Scanner(input_stream2.nextLine());
				x = vertex_check.nextInt();
				y = vertex_check.nextInt();
				
				graph.checkEdge(x, y);
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e);
		}
		finally
		{
			input_stream.close();
		}

	}

}
