#ifndef GPS_H
#include "microtime.h"
#include "coordinate.h"

class GPS
{
	//a struct to contain the info for each tranmitter
	struct transmitter
	{
		MicroTime Time;
		Coordinate coordinate;
	};

	/* These are the public methods used to create a GPS object
			Coordinate triangulate which takes in one MicrtoTime object to get a location
			GPS() constructor
		The final 3 public are operator overloads for comparing Time objects*/
public:
	Coordinate triangulate(MicroTime t);
	GPS();
private:
	transmitter Atlanta, Baltimore, Cincinnati;
};

//This function calculates the difference in MS between two times
double microDif(MicroTime l, MicroTime r);

#endif
#define GPS_H