#ifndef MICROTIME_H
#include <iostream>
#include "time.h"

class MicroTime : public Time
{
public:
	/* These are the public methods used to create Time objects and set their attributes.
			setMicros() will set the microseconds for the given MicroTime Object
			getMicros() will return the given MicroTime object's microseconds
			MicroTime() will create an object with seconds, minutes, hours and micros set to 0
			MicroTime(int mic) will create an object with micros set to mic, with seconds minutes and hours set to 0
			MicroTime(int sec, int mic) will create an object with micros set to mic, seconds set to sec, with minutes and hours set to 0
			MicroTime(int min, int sec, int mic) will create an object with micros set to mic, seconds set to sec, minutes set to min, and hours set to 0
			MicroTime(int hour, int min, int sec, int mic) will create an object with micros set to mic, seconds set to sec, minutes set to min, and hours set to hour
		The final 3 public are operator overloads for comparing Time objects*/
	void setMicros(int in_mic);
	void setTime(int hour, int min, int sec, int mic);
	int getMicros();
	MicroTime();
	MicroTime(int mic);
	MicroTime(int sec, int mic);
	MicroTime(int min, int sec, int mic);
	MicroTime(int hour, int min, int sec, int mic);

private:
	int micros;
	void validate();
	friend std::ostream& operator<<(std::ostream&, MicroTime&);
};

/*These are operator overloads for comparing Time objects*/
bool operator==(MicroTime& l, MicroTime& r);
MicroTime operator-(MicroTime& l, MicroTime& r);

#endif
#define MICROTIME_H