
public class HTMLTag
{
	HTMLTree[] tree = new HTMLTree[100];
	int size = 0;

	public void addRoot(String t_name)
	{
		tree[0] = new HTMLTree(t_name, "");
		size++;
	}

	public void add(HTMLTree parent, HTMLTree child)
	{
		int parentIndex = find(parent.name);
		tree[size] = child;
		tree[parentIndex].children.add(size);
		size++;
	}

	public int find(String name)
	{
		for (int i=0; i < size; ++i)
		{
			if (tree[i].name.equals(name))
				return i;
		}
		return -1;
	}
	
	public void printNodes()
	{
		
	}
}
