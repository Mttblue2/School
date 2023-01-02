//brain for an A.I. hedgehog that eats bushes by J. Howard
#include "brain.h"

/** YOU ARE TO COMPLETELY REWRITE THIS FUNCTION **/
/** DELETE EVERYTHING I'VE WRITTEN AND WRITE A  **/
/** FUNCITON THAT DOES NOT ASK FOR INPUT FROM A **/
/** HUMAN USER. YOU ARE WRITING AN ARTIFICIAL   **/
/** INTELLIGENCE FUNCTION.                      **/

int make_move(int view[5][5])
{
	int index1, index2;
	bool is_bush = false;
	bool in_line = false;
	bool left = false;
	bool right = false;
	bool wall = false;

	//This check the field and marks locations of bushes, if any.
	for (int r = 0; r < 5; r++)
	{
		for (int c = 0; c < 5; c++)
		{
			if (view[r][c] > 0)
			{
				is_bush = true;

				if (c == 2)
				{
					in_line = true;
					index1 = r;
					index2 = c;
				}
				else if (r == 4 && c < 2)
					left = true;
				else if (r == 4 && c > 2)
					right = true;
			}
			if (view[r][c] < 0)
				wall = true;
		}
	}

	//This turns the hedgehog right if it's against a wall
	if (wall == true && view[3][2] < 0)
	{
		cin.get();
		return 3;
	}

	//This is the conditional states that makes the hedgehog decide what to do
	if (is_bush == false)
	{
		cin.get();
		return 2;
	}
	else if (in_line == true && view[3][2] >= 7)
	{
		cin.get();
		return 1;
	}
	else if (right == true && in_line == false)
	{
		cin.get();
		return 3;
	}
	else if (left == true && in_line == false)
	{
		cin.get();
		return 4;
	}
	else if (right == true && in_line == true && view[index1][index2] < 7)
	{
		cin.get();
		return 3;
	}
	else if (left == true && in_line == true && view[index1][index2] < 7)
	{
		cin.get();
		return 4;
	}

	cin.get();
	return 2;


}