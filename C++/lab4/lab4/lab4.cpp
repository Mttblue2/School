#include <iostream>
#include "ascvd.h"
#include "lab4.h"

using namespace std;
int main()
{
	int redo = 1;
	int ldl, age;
	bool dm;

	while (redo == 1)
	{
		if (history_risk() == 0 && ldl_risk(&ldl) == 0 && age_risk(&age) == 0 && dm_risk(&dm, ldl) == 0 && ascvd_risk(age, ldl, dm) == 0)
			cout << "You will not necessarily benefit from statin therapy." << endl;

		cout << endl;
		cout << "Would you like to do a check again? (1 = yes, 0 = no)" << endl;
		cin >> redo;

		while (redo != 1 && redo != 0)
		{
			cout << endl;
			cout << "Please enter a valid choice.";
			cin >> redo;
		}
		cout << "\n\n" << endl;
	}
	cin.get();
	return 0;
}

int history_risk()
{
	int choice;

	cout << "Have you had a heart attack or stroke (1 = yes, 0 = no)?" << endl;
	cin >> choice;
	
	while (choice != 1 && choice != 0)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> choice;
	}

	if (choice == 1)
	{
		cout << "Statin Therapy is beneficial";
		cout << endl;
		return 1;
	}

	return 0;
}

int ldl_risk(int* ldl)
{
	cout << "Please enter your LDL. Value must be 1-300" << endl;
	cin >> *ldl;

	while (*ldl < 1 || *ldl >= 190)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> *ldl;
	}

	if (*ldl >= 190)
	{
		cout << "Statin Therapy is beneficial";
		cout << endl;
		return 1;
	}

	return 0;
}

int age_risk(int* age)
{
	cout << "Please enter your age" << endl;
	cin >> *age;

	while (*age > 130 || *age < 0)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> *age;
	}

	if (*age < 40 || *age > 79)
		return 0;
	else
	{
		cout << "Statin Therapy is beneficial";
		cout << endl;
		return 1;
	}
}

int dm_risk(bool* dm, int ldl)
{
	cout << "Are you a diabetic? (1 = yes, 0 = no)" << endl;
	cin >> *dm;

	while (*dm != 1 && *dm != 0)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> *dm;
	}

	if (*dm == true && ldl >= 70)
	{
		cout << "Statin Therapy is beneficial";
		cout << endl;
		return 1;
	}
	else
		return 0;
}

int ascvd_risk(int age, int ldl, bool dm)
{
	bool female, white, treated, smoker;
	int tchol, hdl, sbp;

	cout << "Please enter your gender. (1 = Female, 0 = Male)" << endl;
	cin >> female;

	while (female != 1 && female != 0)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> female;
	}

	cout << "Please enter your race. (1 = White, 0 = Not White)" << endl;
	cin >> white;

	while (white != 1 && white != 0)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> white;
	}

	cout << "Are you taking blood pressure medicine? (1 = Yes, 0 = No)" << endl;
	cin >> treated;

	while (treated != 1 && treated != 0)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> treated;
	}

	cout << "Do you, or have you ever smoked? (1 = Yes, 0 = No)" << endl;
	cin >> smoker;

	while (smoker != 1 && smoker != 0)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> smoker;
	}

	cout << "Please enter your total-cholesterol. (Value must be between 20 - 100)" << endl;
	cin >> tchol;

	while (tchol < 20 || tchol > 1000)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> tchol;
	}

	cout << "Please enter your HDL. (Value must be between 1 - 200)" << endl;
	cin >> hdl;

	while (hdl < 1 || hdl > 200)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> hdl;
	}

	cout << "Please enter your SBP. (Value must be between 30 - 300)" << endl;
	cin >> sbp;

	while (sbp < 1 || sbp > 300)
	{
		cout << endl;
		cout << "Please enter a valid choice." << endl;
		cin >> sbp;
	}

	if (ascvd(female, white, age, tchol, hdl, sbp, treated, smoker, dm) > 7.5)
	{
		cout << "Statin Therapy is beneficial";
		cout << endl;
		return 1;
	}
	else
	{
		return 0;
	}
}