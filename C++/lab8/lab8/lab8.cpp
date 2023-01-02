#include <iostream>
#include "time.h"
#include "microtime.h"
#include "coordinate.h"
#include "GPS.h"

using namespace std;

int main()
{
	GPS gps;
	MicroTime t(12, 0, 0, 0);
	Coordinate c = gps.triangulate(t);

	cout << c << endl;

	cin.get();
	return 0;
}