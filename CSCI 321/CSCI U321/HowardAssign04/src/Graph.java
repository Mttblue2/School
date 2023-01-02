import java.text.NumberFormat;

public class Graph
{
	private int matrix[][];
	private boolean matrix_visited[];
	private String[] names;
	private int vertices, v_visited;
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	public Graph(String[] name)
	{
		this.matrix = new int[name.length][name.length];
		this.matrix_visited = new boolean[name.length];
		this.vertices = name.length;
		this.names = name.clone();
	}

	public void addEdge(int startV, int endV, int weight)
	{
		matrix[startV][endV] = weight;
		matrix[endV][startV] = weight;
	}

	public int prims()
	{
		int s_path, e_path, s_distance, total=0;
		matrix_visited[0] = true;
		v_visited++;

		while (v_visited < vertices)
		{
			s_path = -1;
			e_path = -1;
			s_distance = Integer.MAX_VALUE;

			for (int x = 0; x < vertices; x++)
			{
				if (matrix_visited[x] == true)
				{
					for (int y = 0; y < vertices; y++)
					{
						if (matrix[x][y] > 0 && matrix_visited[y] == false)
						{
							if (matrix[x][y] < s_distance)
							{
								s_distance = matrix[x][y];
								s_path = x;
								e_path = y;
							}
						}
					}
				}
			}
			matrix_visited[e_path] = true;
			v_visited++;
			total = total + s_distance;

			System.out.println(names[s_path] + " - " + names[e_path] + " (" + fmt.format(s_distance * 1000) + ")");
		}

		return total;
	}
}
