/*******************************************************************
 A latitude/longitude coordinate.
 Latitude and Longitude are in degrees.
 The distance function uses the Haversine formula.
********************************************************************/
#include <math.h> // for M_PI
#include <iostream> // for ostream
#define M_PI 3.14159

#ifndef COORDINATE_H

class Coordinate {
	double latitude;
	double longitude;
	/**
	 * Latitude must be between -90 and 90.
	 * Longitude must be between -180 and 180.
	 */
	void validate();
public:
	/* Getters */
	double getLatitude() const { return latitude; }
	double getLongitude() const { return longitude; }
	/* Setters */
	void setLatitude(double new_latitude);
	void setLongitude(double new_longitude);
	/* Constructors */
	Coordinate();
	Coordinate(double new_latitude, double new_longitude);
	/* Operator Overloads */
	friend std::ostream& operator<<(std::ostream& os, const Coordinate& t);
};

/* Returns the distance in km between two coordinates */
double distance(Coordinate a, Coordinate b);

/* Triangulates the position of a coordinate given three other coordinates and the distance to each one */
/* a = Coordinate a and da = Distance to a
 * b = Coordiante b and db = Distance to b
 * c = Coordinate c and dc = Distance to c
 */
Coordinate triangulate(Coordinate a, double da, Coordinate b, double db, Coordinate c, double dc);

#endif
#define COORDINATE_H
