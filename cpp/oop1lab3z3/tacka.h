#pragma once

#include "lista.h"

using namespace std;

class tacka{
private:

	int x, y;

public:
	
	tacka(int x, int y) : x(x), y(y) {}

	friend double udaljenost(const tacka& t1, const tacka& t2);
	friend bool operator==(const tacka& t1, const tacka& t2);

	friend ostream& operator<<(ostream& os, const tacka& t);
};

