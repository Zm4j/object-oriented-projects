#pragma once

#include <iostream>
#include "lista.h"

using namespace std;

class artikal{
private:

	string naziv;
	int barkod;
	double cena;

public:

	artikal(string naziv, int barkod, double cena) : naziv(naziv), barkod(barkod), cena(cena) {}

	string getnaziv() const { return naziv; }
	int getbarkod() const { return barkod; }
	double getcena() const { return cena; }

	friend bool operator==(const artikal&a, const artikal& b);

};

