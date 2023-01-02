import java.util.LinkedList;

public class HTMLTree
{
	String name, body;
	LinkedList<Integer> children;
	
	public HTMLTree(String t_name, String t_body)
	{
		this.name = t_name;
		this.body = t_body;
	}
}
