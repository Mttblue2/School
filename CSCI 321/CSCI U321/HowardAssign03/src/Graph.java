
public class Graph
{
	private int matrix[][];
	private int path[];
	private int noVertices;
	private int path_int;
	private String full_path;
	private boolean finished = false;
	private boolean found = false;

	public Graph(int noVertices)
	{
		this.noVertices = noVertices;
		matrix = new int[noVertices][noVertices];
	}

	public void addEdge(int startV, int endV, int connected)
	{
		matrix[startV][endV] = connected;
	}

	public void checkEdge(int startV, int endV)
	{
		full_path = "";
		path = new int[noVertices * 2];
		path_int = 0;
		found = false;
		finished = false;
		String path = this.DFS(startV, endV);

		if (path.equals("no path"))
			System.out.println("No path from " + startV + " to " + endV + " exists.");
		else if (path.equals("direct path"))
			System.out.println("An direct edge between " + startV + " and " + endV + " exists.");
		else
			System.out.println("The path from " + startV + " to " + endV + " is: " + path);
	}

	public String DFS(int v, int n)
	{
		boolean visited[] = new boolean[noVertices];

		DFS(v, n, visited);

		for (int y = 0; y < noVertices; y++)
		{
			if (path[y] == n)
			{
				found = true;
				full_path = full_path + path[y];
				break;
			}
			else
				full_path = full_path + path[y] + " - ";
		}
		if (found == false)
			full_path = "no path";
		if (matrix[v][n] == 1)
			full_path = "direct path";

		return full_path;

	}

	public void DFS(int v, int n, boolean visited[])
	{
		visited[v] = true;
		int i = 0;

		// Perform the visit
		path[path_int] = v;
		path_int++;

		while (i < noVertices && !finished)
		{
			if (matrix[v][i] == 1 && !visited[i])
			{
				DFS(i, n, visited);
				path_int--;
				if (path[path_int] == n)
					finished = true;
			}
			++i;
		}
	}
}
