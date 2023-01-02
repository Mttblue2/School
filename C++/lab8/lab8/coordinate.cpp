#include "coordinate.h"

/* Setters */
void Coordinate::setLatitude(double new_latitude) {
	latitude = new_latitude;
	validate();
}
void Coordinate::setLongitude(double new_longitude) {
	longitude = new_longitude;
	validate();
}

/* Constructors */
Coordinate::Coordinate() {
	latitude = longitude = 0;
}
Coordinate::Coordinate(double new_latitude, double new_longitude) {
	latitude = new_latitude;
	longitude = new_longitude;
}

/* Operator Overloads */
std::ostream& operator<<(std::ostream& os, const Coordinate& t) {
	return os << t.getLatitude() << "/" << t.getLongitude();
}

/* Other Methods */
void Coordinate::validate() {
	while(latitude < -90) latitude+= 90;
	while(latitude > 90) latitude-= 90;
	while(longitude < -180) longitude+= 180;
	while(longitude > 180) longitude-= 180;
}

double distance(Coordinate a, Coordinate b) {
	double er = 6371; // Radius of the earth in kilometers
	double dlat = (b.getLatitude() - a.getLatitude())*M_PI/180;
	double dlon = (b.getLongitude() - a.getLongitude())*M_PI/180;
	double ax = pow(sin(dlat/2),2) + cos(a.getLatitude()*M_PI/180) * cos(b.getLatitude()*M_PI/180) * pow(sin(dlon/2),2);
	double cx = 2 * atan2(sqrt(ax), sqrt(1-ax));
	double dx = er * cx;
	return dx;
}

/**
 * I included this because some students will find it interesting.
 * It should be obvious that the "proper" solution would be to solve the distance formula with three sets of unknowns.
 * The following function was given by a student - even after I supplied all students with the distance function above.
 * Instead of directly solving for the unknowns, the student used multiple for loops to hunt down the answer.
 * See if you can follow the logic.
 * I initially gave it a poor grade because I assumed it was nonsense. Then, I saw that it gave a correct answer.
 * I spent a while picking through it to see that it will work. It is just a very complicated way to do a simple calculation.
 */
Coordinate triangulate(Coordinate a, double da, Coordinate b, double db, Coordinate c, double dc) {
	Coordinate t;
	double bd, d;
	double lat, lon, blat, blon;
	lat=blat = ( a.getLatitude() + b.getLatitude() + c.getLatitude() )/3;
	lon=blon = ( a.getLongitude() + b.getLongitude() + c.getLongitude() )/3;
	t.setLatitude(lat);
	t.setLongitude(lon);
	for(double inc=10; inc>0.000001; inc=inc/10) {
		bd = 9999999999;
		for(lat=blat-9*inc; lat<=blat+9*inc; lat+=inc)
		{
			t.setLatitude(lat);
			d = abs( da-distance(a, t) + db-distance(b, t) + dc-distance(c, t) );
			if(d < bd)
			{
				bd = d;
				blat = lat;
			}
		}
		t.setLatitude(blat);
		for(lon=blon-18*inc; lon<=blon+18*inc; lon+= inc)
		{
			t.setLongitude(lon);
			d = abs( da-distance(a, t) + db-distance(b, t) + dc-distance(c, t) );
			if(d < bd)
			{
				bd = d;
				blon = lon;
			}
		}
		t.setLongitude(blon);
	}
	return t;
}
