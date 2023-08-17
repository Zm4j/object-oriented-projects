#include "lista.h"
#include "korisnik.h"
#include "vremenskaoznaka.h"
#include "elektronskaporukasatekstom.h"

using namespace std;

int main() {
	cout << "idemo ";
	lista<int> list;
	int a = 2;
	list.dodaj(a);
	list.dodaj(3);
	list.dodaj(4);
	list.dodaj(5);
	list.dodaj(6);
	//list.pisi();
	list.sledecielement();
	list.sledecielement();
	list.sledecielement();
	list.uzmitek() = 8;
	list.sledecielement();
	list.sledecielement();
	list.postavinaprvi();
	//cout << list.brojelemenata();
	lista<int> list2=list;
	//list2 = list;
	list2.pisi();
	cout << '\n';
	korisnik kor1("osoba1", "osoba1@gmail.com");
	korisnik kor2("osoba2", "osoba2@gmail.com");
	cout << kor1;
	
	vremenskaoznaka v(12, 12, 12, 12, 12);
	cout << v << endl;

	elektronskaporuka elp(kor1, kor2, "PORUKA");
	elektronskaporuka elp2=elp;
	elektronskaporukasatekstom poruka1 (kor1, kor2, "PORUKA");
	
	poruka1.dodajtekst("TEKST JE DODAT DOVIDJENJA");
	cout << poruka1;
	poruka1.menjajtekst("\n SRECAN BADNJI DAN");
	cout << poruka1;
	poruka1.posalji();
	poruka1.dodajtekst("IDE GAS");
	cout << poruka1;

}