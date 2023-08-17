#include "put.h"

void put::operator+=(const tacka& t){
	try {
		for (int i = 0; i < niz.getbrojelm(); i++) {
			if (t == niz[i]) throw(GreskaG1());
		}
		niz += t;
	}
	catch (GreskaG1 a) {
		cout << a.what();
	}
}

double put::predjeniput()
{
	double d = 0;
	for (int i = 0; i < niz.getbrojelm()-1; i++) {
		d += udaljenost(niz[i],niz[i+1]);
	}
	return d;

}

ostream& operator<<(ostream& os, const put& p) {
	for (int i = 0; i < p.niz.getbrojelm(); i++) {
		os << p.niz[i];
		if (i < p.niz.getbrojelm() - 1) os << '\n';
	}
	return os;
}