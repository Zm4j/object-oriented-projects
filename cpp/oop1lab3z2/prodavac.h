#pragma once

#include "rukovodilac.h"
#include "artikal.h"

using namespace std;

struct de {
	artikal a;
	double marza;
	int dan;
};


class prodavac: public rukovodilac{
private:

	string ime;

	lista<de> katalog;

	bool odradjeno = 0;

public:

	prodavac(string ime) : ime(ime) {}

	virtual double izracunaj(artikal a) override;
	void dodaj(de iksi) { katalog += iksi; }
	string getime() const { return ime; }

	virtual void obradaa(posiljka* p) override;
};

