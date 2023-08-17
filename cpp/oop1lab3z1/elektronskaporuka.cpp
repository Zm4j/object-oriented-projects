#include "elektronskaporuka.h"

void elektronskaporuka::kopiraj(const elektronskaporuka& t){
	posailjaoc = new korisnik(t.posailjaoc->getime(),t.posailjaoc->getadresa());
	primaoc = new korisnik(t.primaoc->getime(), t.primaoc->getadresa());
	stanje = t.stanje;
	naslov = t.naslov;
}

void elektronskaporuka::brisi(){
	//delete posailjaoc;
	//delete primaoc;
	posailjaoc = nullptr;
	primaoc = nullptr;
}

void elektronskaporuka::premesti(elektronskaporuka& t){
	posailjaoc = t.posailjaoc;
	primaoc = t.primaoc;
	stanje = t.stanje;
	naslov = t.naslov;
}

elektronskaporuka::elektronskaporuka(korisnik& k1, korisnik& k2, string naslov1){
	posailjaoc = &k1;
	primaoc = &k2;
	naslov = naslov1;
}

elektronskaporuka& elektronskaporuka::operator=(const elektronskaporuka& t)
{
	if (this != &t) {
		brisi();
		kopiraj(t);
	}
	return *this;
}

elektronskaporuka& elektronskaporuka::operator=(elektronskaporuka&& t)
{
	if (this != &t) {
		brisi();
		premesti(t);
	}
	return *this;
}

ostream& operator<<(ostream& os, const elektronskaporuka& e){
	os << e.getnaslov() << '\n' << e.getpos() << e.getpri() << e.pisi() << '\n';
	return os;
}
