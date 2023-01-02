import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;

public class analyzer
{

	public static void main(String[] args)
	{
		Scanner input_stream = null;
		String[] keywords = { "int", "double", "String" };
		char[] operators = { '=', '(', ')', '+', '-', '*', '/', ',', ';' };

		try
		{
			int line_counter = 1;

			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
			JFileChooser j = new JFileChooser();
			j.setFileFilter(filter);
			j.setAcceptAllFileFilterUsed(false);

			System.out.println("Please choose your source code file.");
			System.out.println();
			j.showOpenDialog(null);

			File text = j.getSelectedFile();

			if (text != null)
			{
				input_stream = new Scanner(text);
				StringBuilder token = new StringBuilder(0);

				while (input_stream.hasNextLine() == true)
				{
					String current_line = input_stream.nextLine().toString();

					for (int x = 0; x < current_line.length(); x++)
					{
						// finding string constant
						if (current_line.charAt(x) == '"')
						{
							int found_at = x;
							x++;

							while (current_line.charAt(x) != '"')
							{
								token.append(current_line.charAt(x));
								x++;
							}

							System.out.println("Line" + line_counter + ": " + (found_at + 1) + " string constant: \""
									+ token.toString() + "\"");

							token.setLength(0);
						}

						// finding number constants
						if (Character.isDigit(current_line.charAt(x)))
						{
							Boolean is_double = false;
							int found_at = x;

							while (Character.isDigit(current_line.charAt(x)) == true)
							{
								token.append(current_line.charAt(x));
								x++;
							}

							if (current_line.charAt(x) == '.')
							{
								is_double = true;
								token.append(current_line.charAt(x));
								x++;

								while (Character.isDigit(current_line.charAt(x)) == true)
								{
									token.append(current_line.charAt(x));
									x++;
								}
							}

							if (is_double == false)
								System.out.println("Line" + line_counter + ": " + (found_at + 1) + " int constant: "
										+ token.toString());
							if (is_double == true)
								System.out.println("Line" + line_counter + ": " + (found_at + 1) + " double constant: "
										+ token.toString());

							x--;
							token.setLength(0);
						}

						// finding identifier's and keywords
						else if (Character.isLetter(current_line.charAt(x)))
						{
							int found_at = x;
							boolean is_keyword = false;
							token.append(current_line.charAt(x));
							x++;

							while (Character.isDigit(current_line.charAt(x)) == true
									|| Character.isLetter(current_line.charAt(x)) == true)
							{
								token.append(current_line.charAt(x));
								x++;
							}

							for (int y = 0; y < 3; y++)
							{
								if (token.toString().equals(keywords[y]))
									is_keyword = true;
							}

							if (is_keyword == true)
								System.out.println("Line" + line_counter + ": " + (found_at + 1) + " keyword: "
										+ token.toString());
							else
								System.out.println("Line" + line_counter + ": " + (found_at + 1) + " identifier: "
										+ token.toString());

							x--;
							token.setLength(0);
						} else
						{
							boolean recognized = false;

							// finding operators
							for (int y = 0; y < 9; y++)
							{
								if (current_line.charAt(x) == operators[y])
								{
									System.out.println("Line" + line_counter + ": " + (x + 1) + " operator: "
											+ current_line.charAt(x));
									recognized = true;
									break;
								}
							}
							// checking for error characters
							if (recognized == false && current_line.charAt(x) != ' ' && current_line.charAt(x) != '"')
								System.out.println("Line" + line_counter + ": " + (x + 1) + " error: "
										+ current_line.charAt(x) + " not recognized");
						}
					}
					line_counter++;
				}
			}

		} catch (Exception e)
		{
			System.out.println("Error: " + e);
		} finally
		{
			if (input_stream != null)
				input_stream.close();
		}

	}

}
