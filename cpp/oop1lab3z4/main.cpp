#include <iostream>

#include "privilegovantim.h"
#include "par.h"
#include "mec.h"

using namespace std;

int main() {

	igrac i1("igrac1", 1200);
	igrac i2("igrac2", 700);
	igrac i3("igrac3");
	igrac i4("igrac4", 500);

	igrac i11("igrac1", 1200);
	igrac i22("igrac2", 700);
	igrac i33("igrac3");
	igrac i44("igrac4", 500);

	i3.menjajvrednost(-10);

	tim tim1("tim1", 10);
	privilegovantim ptim1("tim2", 10,800);
	//tim& ptim1 = *new privilegovantim("ptim1", 10, 800);

	ptim1.prikljuci(i1, 0);
	ptim1.prikljuci(i2, 7);
	ptim1.prikljuci(i3, 4);
	ptim1.prikljuci(i4, 6);

	tim1.prikljuci(i11, 0);
	tim1.prikljuci(i22, 7);
	tim1.prikljuci(i33, 4);
	tim1.prikljuci(i44, 6);

	//cout << tim1 << endl;
	
	par<tim*> p(&tim1, &ptim1);
	cout << tim1 << endl;
	cout << ptim1 << endl;
	cout << endl;
	mec m(p);

	m.odigraj();

	cout << m << endl;

	

	return 0;

}