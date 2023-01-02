#include "GPS.h"

using namespace std;

GPS::GPS()
{
	Atlanta.coordinate.setLatitude(33.7488889);
	Atlanta.coordinate.setLongitude(-84.3880556);
	Atlanta.Time.setTime(11, 59, 59, 9993);

	Baltimore.coordinate.setLatitude(39.2902778);
	Baltimore.coordinate.setLongitude(-76.6125000);
	Baltimore.Time.setTime(11, 59, 59, 9983);

	Cincinnati.coordinate.setLatitude(39.1619444);
	Cincinnati.coordinate.setLongitude(-84.4569444);
	Cincinnati.Time.setTime(11, 59, 59, 9984);
}

double microDif(MicroTime l, MicroTime r)
{
	double lmicro = 0, rmicro = 0;

	if (l.getHours() > 0)
		lmicro += l.getHours() * 36000000;
	if (l.getMinutes() > 0)
		lmicro += l.getMinutes() * 600000;
	if (l.getSeconds() > 0)
		lmicro += l.getSeconds() * 10000;
	lmicro += l.getMicros();

	if (r.getHours() > 0)
		rmicro += r.getHours() * 36000000;
	if (l.getMinutes() > 0)
		rmicro += r.getMinutes() * 600000;
	if (r.getSeconds() > 0)
		rmicro += r.getSeconds() * 10000;
	rmicro += r.getMicros();

	return abs(lmicro - rmicro);
}

Coordinate GPS::triangulate(MicroTime t)
{
	double Ad, Bd, Cd;

	Ad = microDif((MicroTime)Atlanta.Time, t) * 30;
	Bd = microDif((MicroTime)Baltimore.Time, t) * 30;
	Cd = microDif((MicroTime)Cincinnati.Time, t) * 30;

	Coordinate coor = ::triangulate(Atlanta.coordinate, Ad, Baltimore.coordinate, Bd, Cincinnati.coordinate, Cd);

	return coor;
}