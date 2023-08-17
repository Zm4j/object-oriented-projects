#include "prodavac.h"

double prodavac::izracunaj(artikal a){
	for (int i = 0; i < katalog.getbrojelm(); i++) {
		if (a == katalog[i].a) return (double)a.getcena() * katalog[i].marza;
	}
	return 0;
}

void prodavac::obradaa(posiljka* p){
	for (int i = 0; i < katalog.getbrojelm(); i++) {
		if (p->getartikal() == katalog[i].a) {
			p->menjajdetalje(katalog[i].dan, katalog[i].marza * (double)katalog[i].a.getcena());
			return;
		}
	}
}

