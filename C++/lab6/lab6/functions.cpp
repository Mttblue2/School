#include "functions.h"

bool is_valid_row(int row, int board[][9])
{
	int n, i, count;
	for (n = 1; n <= 9; n++)
	{
		count = 0;
		for (i = 0; i < 9; i++)
		{
			if (board[row][i] == n)
				count++;
			if (count > 1)
				return false;
		}
	}
	return true;
}