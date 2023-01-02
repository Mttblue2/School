//Lab 3 by J Howard
#include <iostream>
#include <cmath>

// Make a three sides of a triangle larger.
void embiggen(float* a, float* b, float* c);

// Display the three sides and the area of a triangle.
void display(float a, float b, float c);
using namespace std;

int main()
{
	// Variables for the 3 sides of the triangle
	float a, b, c;
	bool is_triangle = false;

	// Get input from the user
	cout << "Enter three lengths, such as : 3 1.4 7" << endl;
	cout << "Do not enter negative values." << endl;
	cout << "The three sides must make a valid triangle." << endl;
	cin >> a;
	cin >> b;
	cin >> c;

	//checks for an actual triangle
	if (a <= 0 || b <= 0 || c <= 0)
	{
		cout << endl;
		cout << "Error 1: The user entered a negative number";
		cin.get();
		cin.get();
		return 1;
	}
	else if (a + b < c || b + c < a || c + a < b)
	{
		cout << endl;
		cout << "Error 2: The user didn't enter a valid triangle";
		cin.get();
		cin.get();
		return 2;
	}
	else
	{
		is_triangle = true;
	}

	cout << endl;

	// Show the original size
	cout << "Original size : " << endl;
	display(a, b, c);

	// Make the triangle bigger
	embiggen(&a, &b, &c);

	// Show the bigger size
	cout << "Bigger size : " << endl;
	display(a, b, c);

	cin.get();
	cin.get();
	return 0;
}

void embiggen(float* a, float* b, float* c)
{
	float p = *a + *b + *c;

	*a = *a + (*a / p);
	*b = *b + (*b / p);
	*c = *c + (*c / p);
}

void display(float a, float b, float c)
{
	cout << "(A, B, C) = " << "(" << a << ", " << b << ", " << c << ")" << endl;

	float s = (a + b + c) / 2;

	cout << "AREA = " << sqrt(s * (s - a) * (s - b) * (s - c)) << endl;
}