#pragma once

#include <iostream>
#include <ostream>

using namespace std;

class vremenskaoznaka{
private:

	int dan;
	int mesec;
	int godina;
	int sat;
	int minut;

public:

	vremenskaoznaka(int dan1, int mesec1, int godina1, int sat1, int minut1) : dan(dan1), mesec(mesec1), godina(godina1), sat(sat1), minut(minut1) {};

	friend ostream& operator<<(ostream& os, const vremenskaoznaka& v);

};

