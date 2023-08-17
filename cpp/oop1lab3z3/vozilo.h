#pragma once

#include "put.h"

class vozilo{
private:

	string model;
	double jedinica = 0.1;

protected:

	double cena = 120;

public:

	vozilo(string model) :model(model) {}
	virtual double cenaputa(put& p) const;
	friend ostream& operator<<(ostream& os, const vozilo& v);


};

