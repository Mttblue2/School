#include <iostream>
#include "time.h"

using namespace std;

Time::Time()
{
	seconds = 0;
	minutes = 0;
	hours = 0;
}

Time::Time(int sec)
{
	seconds = sec;
	minutes = 0;
	hours = 0;
	validate();
}

Time::Time(int min, int sec)
{
	seconds = sec;
	minutes = min;
	hours = 0;
	validate();
}

Time::Time(int hour, int min, int sec)
{
	seconds = sec;
	minutes = min;
	hours = hour;
	validate();
}

void Time::setSeconds(int in_sec)
{
	seconds = in_sec;
	validate();
}

void Time::setMinutes(int in_min)
{
	minutes = in_min;
	validate();
}

void Time::setHours(int in_hour)
{
	hours = in_hour;
	validate();
}

void Time::setTime(int in_hour, int in_min, int in_sec)
{
	seconds = in_sec;
	minutes = in_min;
	hours = in_hour;
	validate();
}

int Time::getSeconds()
{
	return seconds;
}

int Time::getMinutes()
{
	return minutes;
}

int Time::getHours()
{
	return hours;
}

void Time::validate()
{
	while (seconds < 0)
	{
		seconds += 60;
		minutes--;
	}
	while (seconds > 59)
	{
		seconds -= 60;
		minutes++;
	}
	while (minutes < 0)
	{
		minutes += 60;
		hours--;
	}
	while (minutes > 59)
	{
		minutes -= 60;
		hours++;
	}
}

std::ostream& operator<<(std::ostream& o, Time& t)
{
	if (t.getMinutes() < 10 && t.getSeconds() < 10)
		return o << t.getHours() << ":0" << t.getMinutes() << ":0" << t.getSeconds();
	if (t.getSeconds() < 10)
		return o << t.getHours() << ":" << t.getMinutes() << ":0" << t.getSeconds();
	if (t.getMinutes() < 10)
		return o << t.getHours() << ":0" << t.getMinutes() << ":" << t.getSeconds();
	else
		return o << t.getHours() << ":" << t.getMinutes() << ":" << t.getSeconds();
}

Time& Time::operator=(Time& r)
{
	this->setSeconds(r.getSeconds());
	this->setMinutes(r.getMinutes());
	this->setHours(r.getHours());

	return *this;
}

Time Time::operator+(Time& r)
{
	Time newTime;
	newTime.setSeconds(this->getSeconds() + r.getSeconds());
	newTime.setMinutes(this->getMinutes() + r.getMinutes());
	newTime.setHours(this->getHours() + r.getHours());

	return newTime;
}

Time& Time::operator++(int r)
{
	this->setMinutes(this->getMinutes() + 1);

	return *this;
}

Time operator-(Time& l, Time& r)
{
	Time newTime;
	newTime.setHours(l.getHours() - r.getHours());
	newTime.setMinutes(l.getMinutes() - r.getMinutes());
	newTime.setSeconds(l.getSeconds() - r.getSeconds());

	return newTime;
}

Time operator--(Time& l, int r)
{
	l.setMinutes(l.getMinutes() - 1);

	return l;
}

bool operator==(Time& l, Time& r)
{
	if (l.getHours() != r.getHours())
		return false;
	if (l.getMinutes() != r.getMinutes())
		return false;
	if (l.getSeconds() != r.getSeconds())
		return false;
	return true;
}

bool operator!=(Time& l, Time& r)
{
	if (l.getHours() == r.getHours() && l.getMinutes() == r.getMinutes() && l.getSeconds() == r.getSeconds())
		return false;
	return true;
}

bool operator<(Time& l, Time& r)
{
	if (l.getHours() > r.getHours())
		return false;
	if (l.getHours() == r.getHours() && l.getMinutes() > r.getMinutes())
		return false;
	if (l.getHours() == r.getHours() && l.getMinutes() == r.getMinutes() && l.getSeconds() >= r.getSeconds())
		return false;

	return true;
}

bool operator<=(Time& l, Time& r)
{
	if (l.getHours() > r.getHours())
		return false;
	if (l.getHours() == r.getHours() && l.getMinutes() > r.getMinutes())
		return false;
	if (l.getHours() == r.getHours() && l.getMinutes() == r.getMinutes() && l.getSeconds() > r.getSeconds())
		return false;

	return true;
}

bool operator>(Time& l, Time& r)
{
	if (l.getHours() < r.getHours())
		return false;
	if (l.getHours() == r.getHours() && l.getMinutes() < r.getMinutes())
		return false;
	if (l.getHours() == r.getHours() && l.getMinutes() == r.getMinutes() && l.getSeconds() <= r.getSeconds())
		return false;

	return true;
}

bool operator>=(Time& l, Time& r)
{
	if (l.getHours() < r.getHours())
		return false;
	if (l.getHours() == r.getHours() && l.getMinutes() < r.getMinutes())
		return false;
	if (l.getHours() == r.getHours() && l.getMinutes() == r.getMinutes() && l.getSeconds() < r.getSeconds())
		return false;

	return true;
}