#pragma once

#include "elektronskaporuka.h"

class GreskaPriMenjanju{};

class elektronskaporukasatekstom : public elektronskaporuka{
private:
	string tekst;
public:
	
	elektronskaporukasatekstom(korisnik& k1, korisnik& k2, string naslov1) : elektronskaporuka(k1, k2, naslov1) {}

	string pisi() const override;
	void dodajtekst(string tekst1);
	void menjajtekst(string tekst1);
};

