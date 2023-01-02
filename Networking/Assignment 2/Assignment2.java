import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment2 extends Thread
{
	String name;
	
	public Assignment2 (String name)
	{
		this.name = name;
	}

	
	public static void main(String[] args) throws InterruptedException
	{
		split();
		
		Assignment2 thread1 = new Assignment2("input1");
		Assignment2 thread2 = new Assignment2("input2");
		Assignment2 thread3 = new Assignment2("input3");
		Assignment2 thread4 = new Assignment2("input4");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		
		
		merge("input1.txt", "input2.txt", "input1a.txt");
		merge("input3.txt", "input4.txt", "input2a.txt");
		merge("input1a.txt", "input2a.txt", "result.txt");
	}	
	public synchronized void sortThread() throws IOException
	{
		File file = new File(name + ".txt");
		Scanner reader = new Scanner(file);
		
		int[] mixed = new int[250000];
		
		for (int x = 0; x < mixed.length; x++)
			mixed[x] = reader.nextInt();
		
		Arrays.sort(mixed);
		
		reader.close();
		file.delete();
		
		file = new File(name + ".txt");
		FileWriter writer = new FileWriter(file);
		
		for (int x = 0; x < mixed.length; x++)
			writer.write(mixed[x] + "\n");
		
		writer.close();
	}
	
	public void run()
	{
		try
		{
			sortThread();
		} catch (Exception e)
		{
			System.out.println("Error: " + e);
		}
	}

	public static void merge(String old1, String old2, String newFile)
	{
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		
		try
		{
			int x = 0, y = 0;
			
			File file1 = new File(old1);
			File file2 = new File(old2);
			File file3 = new File(newFile);
			FileWriter writer = new FileWriter(file3);
			
			Scanner scanner = new Scanner(file1);
			
			while (scanner.hasNextInt())
				array1.add(scanner.nextInt());
			
			scanner = new Scanner(file2);
			
			while (scanner.hasNextInt())
				array2.add(scanner.nextInt());
			
			scanner.close();
			
			while (x + y <= array1.size() + array2.size() - 2)
			{
				if (x >= array1.size())
				{
					while (y < array2.size())
					{
						writer.write(array2.get(y) + "\n");
						y++;
					}
				}
				else if (y >= array2.size())
				{
					while (x < array1.size())
					{
						writer.write(array1.get(x) + "\n");
						x++;
					}
				}
				
				else if (array1.get(x) <= array2.get(y))
				{
					writer.write(array1.get(x) + "\n");
					x++;
				}
				else
				{
					writer.write(array2.get(y) + "\n");
					y++;
				}
			}
			writer.close();
			
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e);
		}
	}
	
	public static void split()
	{
		try
		{
			File file = new File("input.txt");
			Scanner scanner = new Scanner(file);
			
			for (int x = 1; x <= 4; x++)
			{
				file = new File("input" + x + ".txt");
				file.createNewFile();
				FileWriter writer = new FileWriter(file);
				
				for (int y = 0; y < 250000; y++)
					writer.write(scanner.nextLine() + "\n");
				
				writer.close();
			}
			
			scanner.close();
		} catch (Exception e)
		{
			System.out.println("Error:" + e);
		}
	}
}