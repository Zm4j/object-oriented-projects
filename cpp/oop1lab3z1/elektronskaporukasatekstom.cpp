#include "elektronskaporukasatekstom.h"

string elektronskaporukasatekstom::pisi() const{
    return "\""+this->tekst+"\"";
}

void elektronskaporukasatekstom::dodajtekst(string tekst1)
{
	try {
		if (stanje == POSLATA) throw(GreskaPriMenjanju());
		tekst = tekst1;
	}
	catch (GreskaPriMenjanju a) {
		cout << "GRESKA";
	}
}

void elektronskaporukasatekstom::menjajtekst(string tekst1)
{
	try {
		if (stanje == POSLATA) throw(GreskaPriMenjanju());
		tekst += tekst1;
	}
	catch (GreskaPriMenjanju a) {
		cout << "GRESKA";
	}
}