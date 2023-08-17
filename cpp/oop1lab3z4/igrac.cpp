#include "igrac.h"

void igrac::menjajvrednost(double procenat){
	broj = (int)((double)broj * (1 + procenat / 100));
}

bool operator==(const igrac& i1, const igrac& i2){
	return i1.broj == i2.broj && i2.ime == i1.ime;
}

ostream& operator<<(ostream& os, const igrac& i){
	os << i.ime << '#' << i.broj;
	return os;
}
