#include <iostream>
#include <fstream>
#include "lab5.h"

using namespace std;

struct bet
{
	bool home;
	int amount;
	int fee;
	int line;
};

int main()
{
	ifstream datafile;

	int bet bets[];

	datafile.open("bets.csv");
	if (!datafile) {

		cout << "Failed to open file" << endl;

		cin.get();

		return 1;

	}

	for (int i = 0; i < 10; i++)
	{
		datafile >> bets[i].home;
		datafile >> bets[i].amount;
		datafile >> bets[i].fee;
		datafile >> bets[i].line;
	}
	datafile.close();



}