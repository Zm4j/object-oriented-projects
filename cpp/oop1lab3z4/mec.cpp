#include "mec.h"

void mec::odigraj()
{
	double rez1 = this->timovi.prvi()->gettim();
	double rez2 = this->timovi.drugi()->gettim();
	ishodi = (ishodmec)((rez1 > rez2) + 2 * (rez1 < rez2));
	odigran = 1;
	if (ishodi == 0) return;
	int procenat = 10*-(ishodi==2);
	this->timovi.prvi()->menjajtim(procenat);
	this->timovi.drugi()->menjajtim(-procenat);
}

par<int> mec::ishod()const {
	try {
		if (odigran == 0) throw GreskaMec();
		return par<int>((ishodi == NERESENO) + 3 * (ishodi == POBEDA_DOMACIN), (ishodi == NERESENO) + 3 * (ishodi == POBEDA_GOST));
	}
	catch (GreskaMec a) {
		cout << a.what();
	}
}

ostream& operator<<(ostream& os, const mec& m){
	par<tim> m1(*(m.timovi.prvi()), *(m.timovi.drugi()));
	os << m1 << '\n' << m.ishod();
	return os;
}
