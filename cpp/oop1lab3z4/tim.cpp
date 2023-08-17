#include "tim.h"

void tim::kopiraj(const tim& t){
	ime = t.ime;
	maksbrojigraca = t.maksbrojigraca;
	trenbroj = t.trenbroj;
	niz = new igrac* [maksbrojigraca];
	for (int i = 0; i < maksbrojigraca; i++) {
		if (t[i] == nullptr) niz[i] = nullptr;
		else niz[i] = new igrac(t[i]->getime(),t[i]->getbroj());
	}
}

void tim::brisi(){
	delete [] niz;
}

void tim::premesti(tim& t){
	ime = t.ime;
	maksbrojigraca = t.maksbrojigraca;
	trenbroj = t.trenbroj;
	niz = t.niz;
}

tim::tim(string ime, int maks) : ime(ime), maksbrojigraca(maks){
	niz = new igrac * [maksbrojigraca];
	for (int i = 0; i < maksbrojigraca; i++) niz[i] = nullptr;
}

tim& tim::operator=(const tim& t){
	if (&t != this) {
		brisi();
		kopiraj(t);
	}
	return *this;
}

tim& tim::operator=(tim&& t){
	if (&t != this) {
		brisi();
		premesti(t);
	}
	return *this;
}

void tim::prikljuci(const igrac& igr, const int& ind){
	if (ind < 0 || ind >= maksbrojigraca) return;
	if (niz[ind] == nullptr) trenbroj++;
	niz[ind] = const_cast<igrac*>(&igr);
}

double tim::gettim() const{
	double sum = 0;
	//return sum;
	for (int i = 0; i < maksbrojigraca; i++) {
		if (niz[i] != nullptr) {
			sum += niz[i]->getbroj();
			//sum += 1;
		}
	}
	return (double)(sum / trenbroj);
}

void tim::menjajtim(int procenat){
	for (int i = 0; i < maksbrojigraca; i++) {
		if (this->niz[i] != nullptr) {
			this->niz[i]->menjajvrednost(procenat);
		}
	}
}

igrac* tim::operator[](int ind) const{
	if (ind < 0 || ind >= maksbrojigraca) return nullptr;
	return niz[ind];
}

bool operator==(const tim& t1, const tim& t2){
	if (t1.ime != t2.ime || t1.maksbrojigraca != t2.maksbrojigraca || t1.trenbroj != t2.trenbroj) return false;
	for (int i = 0; i < t1.maksbrojigraca; i++) {
		if((t1[i] == nullptr) ^ (t2[i] == nullptr)) return false;
		if (t1[i] == nullptr) continue;
		if (*t1[i] == *t2[i]) continue;
		else return false;
	}
	return true;
}

ostream& operator<<(ostream& os, const tim& t)
{
	os << t.ime << '[';
	for (int i = 0; i < t.maksbrojigraca; i++) {
		if (t[i] != nullptr) os << *t[i];
		if (i < t.maksbrojigraca - 1) os << ", ";
	}
	os << ']' << t.pisi();
	return os;
}
