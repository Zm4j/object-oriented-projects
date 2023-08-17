#pragma once

#include "artikal.h"

class rukovodilac;

struct d {
	int brdana;
	double cena;
};

class posiljka{
private:
	
	static int brojj;
	const int id = brojj++;
	artikal a;
	lista<rukovodilac*>list;

	d detalji;
	bool obradjeno = 0;

public:

	posiljka(artikal a1) : a(a1) { detalji = { 0,0 }; }

	artikal getartikal () const { return a; }
	int getindentifikator() const { return id; }
	d getdetalji() const;
	void menjajdetalje(int dan, double cena);
	void izracunaj();
	void operator+=(rukovodilac* r);
	friend ostream& operator<<(ostream& os, const posiljka& p);
};
