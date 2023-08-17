#include <iostream>

#include "lista.h"
#include "artikal.h"
#include "prodavac.h"

using namespace std;

int posiljka::brojj = 0;

int main() {
	artikal a("artikal1", 123, 69.123);
	prodavac *p = new prodavac("Lik iz kst-a");
	prodavac& pp = *new prodavac("drugi lik iz kst-a");
	de st = { a,4.20,10 };
	p->dodaj(st);
	pp.dodaj(st);
	posiljka po(a); posiljka po1(a);
	po += p;
	//po += &pp;
	po.getdetalji();
	po.izracunaj();
	d det = po.getdetalji();
	cout << det.cena << '-' << det.brdana << endl;

	po += p;
	cout << po1;
	return 69;
}