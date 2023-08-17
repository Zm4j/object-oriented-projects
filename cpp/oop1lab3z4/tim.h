#pragma once

#include "igrac.h"

class tim {
protected:

	string ime;
	int maksbrojigraca;
	int trenbroj = 0;
	igrac** niz;

	void kopiraj(const tim& t);
	void brisi();
	void premesti(tim& t);

public:
	tim(string ime, int maks);

	tim(const tim& t) { kopiraj(t); }
	tim(tim&& t) { premesti(t); }
	tim& operator=(const tim& t);
	tim& operator=(tim&& t);
	~tim() { brisi(); }

	virtual void prikljuci(const igrac& igr, const int& ind);
	igrac getigrac(const int& ind) const { return *niz[ind]; }
	int gettren() const { return trenbroj; }
	double gettim() const;
	void menjajtim(int procenat);

	igrac* operator[](int ind) const;

	virtual string pisi() const { return ""; }

	friend bool operator==(const tim& t1, const tim& t2);
	friend ostream& operator<<(ostream& os, const tim& t);
};

