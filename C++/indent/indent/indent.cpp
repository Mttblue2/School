//Program to practice indentation in C++ by J. Howard
#include <iostream>
using namespace std;
int main()
{
	int i;
	int n = 3;
	for (i = 1; i < 5; i++)
	{
		if (n + 1 > i && n - 1 < i)
		{
			cout << "hello" << endl;
		}
		else
		{
			cout << "goodbye" << endl;
		}
	}
	i = n;
	while (i > 10)
		i = i - 2;
}