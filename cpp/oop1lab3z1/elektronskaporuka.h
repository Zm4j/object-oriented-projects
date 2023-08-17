#pragma once

#include "korisnik.h"

enum stanjeporuka {U_PRIPREMI=0,POSLATA=1,PRIMLJENA=2};

class elektronskaporuka{
protected:

	korisnik* posailjaoc;
	korisnik* primaoc;
	stanjeporuka stanje=U_PRIPREMI;
	string naslov;

	void kopiraj(const elektronskaporuka& t);
	void brisi();
	void premesti(elektronskaporuka& t);

	virtual string pisi() const {return "";}

public:

	elektronskaporuka(korisnik& k1, korisnik& k2, string naslov1);

	elektronskaporuka(const elektronskaporuka& t) { kopiraj(t); }
	elektronskaporuka(elektronskaporuka&& t) { premesti(t); }
	elektronskaporuka& operator=(const elektronskaporuka& t);
	elektronskaporuka& operator=(elektronskaporuka&& t);
	virtual ~elektronskaporuka() { brisi(); }


	korisnik& getpos() const { return *posailjaoc; }
	korisnik& getpri() const { return *primaoc; }
	stanjeporuka getstanje() const { return stanje; }
	string getnaslov() const { return naslov; }
	void posalji() {stanje = POSLATA;}

	friend ostream& operator<< (ostream& os, const elektronskaporuka& e);

};

