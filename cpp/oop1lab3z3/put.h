#pragma once

#include "tacka.h"

class GreskaG1 : public exception {
public:
	const char* what() const override {
		return "Greska, postoje 2 iste tacke\n";
	}
};

class put{
private:

	lista <tacka> niz;

public:

	void operator+=(const tacka& t);
	double predjeniput();
	friend ostream& operator<<(ostream& os, const put& p);

};

