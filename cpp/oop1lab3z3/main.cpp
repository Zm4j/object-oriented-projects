#include <iostream>
#include "vozilo.h"

using namespace std;

int main() {
	tacka t1(1, 1);
	tacka t2(1, 2);
	tacka t3(1, 3);

	t1 = tacka(1,9);

	put p;
	p += t1;
	p += t2;
	p += t3;
	p += tacka(1, 4);

	vozilo v("Yugo45");

	cout << p;

	cout << endl;

	cout << v.cenaputa(p);
}