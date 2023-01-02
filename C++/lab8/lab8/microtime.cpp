#include <iostream>
#include "time.h"
#include "microtime.h"

using namespace std;

MicroTime::MicroTime()
{
	micros = 0;
}

MicroTime::MicroTime(int mic)
{
	micros = mic;
	validate();
}

MicroTime::MicroTime(int sec, int mic) : Time(sec)
{
	micros = mic;
	validate();
}

MicroTime::MicroTime(int min, int sec, int mic) : Time(min, sec)
{
	micros = mic;
	validate();
}

MicroTime::MicroTime(int hour, int min, int sec, int mic) : Time(hour, min, sec)
{
	micros = mic;
	validate();
}

void MicroTime::setMicros(int in_mic)
{
	micros = in_mic;
	validate();
}
void MicroTime::setTime(int hour, int min, int sec, int mic)
{
	Time::setTime(hour, min, sec);
	micros = mic;
}

int MicroTime::getMicros()
{
	return micros;
}

void MicroTime::validate()
{
	while (micros < 0)
	{
		micros += 10000;
		setSeconds(getSeconds() - 1);
	}
	while (micros >= 10000)
	{
		micros -= 10000;
		setSeconds(getSeconds() + 1);
	}
}

std::ostream& operator<<(std::ostream& o, MicroTime& t)
{
	if (t.getMicros() < 10)
		return o << (Time&)t << ":000" << t.getMicros();
	if (t.getMicros() >= 10 && t.getMicros() < 100)
		return o << (Time&)t << ":00" << t.getMicros();
	if (t.getMicros() >= 100 && t.getMicros() < 1000)
		return o << (Time&)t << ":0" << t.getMicros();

	return o << (Time &)t << ":" << t.getMicros();
}

bool operator==(MicroTime& l, MicroTime& r)
{
	if ((Time&)l == (Time&)r)
		if (l.getMicros() == r.getMicros())
			return true;
	return false;
}
