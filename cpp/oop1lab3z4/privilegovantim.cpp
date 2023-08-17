#include "privilegovantim.h"
#include <string>

privilegovantim::privilegovantim(string ime, int maksbrojigraca, int min) : tim(ime, maksbrojigraca), minimalna(min) {}

void privilegovantim::prikljuci(const igrac& igr, const int& ind){
	try {
		if (igr.getbroj() < minimalna) throw GreskaPTim();
		tim::prikljuci(igr, ind);
	}
	catch (GreskaPTim a) {
		cout << a.what();
	}
}

string privilegovantim::pisi() const{
	string s;
	s = "(" + to_string(minimalna) + ")";
	return s;
}
