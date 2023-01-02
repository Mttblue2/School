#ifndef TIME_H
#include <iostream>
/* this file contains a class that encapsulates and simplifies working with time. */

class Time
{
public:
	/* These are the public methods used to create Time objects and set their attributes.
			setSeconds(int in_sec) will set the seconds for the given Time Object
			setMinutes(int in_min) will set the minutes for the given Time Object
			setHours(int in_hour) will set the hours for the given Time Object
			getSeconds() will return the given Time object's seconds
			getMinutes() will return the given Time object's minutes
			getHours() will return the given Time object's hours
			Time() will create an object with seconds, minutes and hours set to 0
			Time(int sec) will create an object with seconds set to sec with minutes and hours set to 0
			Time(int min, int sec) will create an object with seconds set to sec, minutes set to min and hours set to 0
			Time(int hour, int min, int sec) will create an object with seconds set to sec, minutes set to min and hours set to hour
		The final 3 public are operator overloads for comparing Time objects*/
	void setSeconds(int in_sec);
	void setMinutes(int in_min);
	void setHours(int in_hour);
	void setTime(int in_hour, int in_min, int in_sec);
	int getSeconds();
	int getMinutes();
	int getHours();
	Time();
	Time(int sec);
	Time(int min, int sec);
	Time(int hour, int min, int sec);
	Time& operator=(Time& r);
	Time operator+(Time& r);
	Time& operator++(int);


private:
	int hours, minutes, seconds;
	void validate();
	friend std::ostream& operator<<(std::ostream&, Time&);

};

/*These are operator overloads for comparing Time objects*/
Time operator-(Time& l, Time& r);
Time operator--(Time& l, int);
bool operator==(Time& l, Time& r);
bool operator!=(Time& l, Time& r);
bool operator<(Time& l, Time& r);
bool operator<=(Time& l, Time& r);
bool operator>(Time& l, Time& r);
bool operator>=(Time& l, Time& r);


#endif
#define TIME_H

