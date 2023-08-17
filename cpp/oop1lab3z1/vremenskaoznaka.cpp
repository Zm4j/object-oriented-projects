#include "vremenskaoznaka.h"

ostream& operator<<(ostream& os, const vremenskaoznaka& v){
	os << v.dan << '.' << v.mesec << '.' << v.godina << '-' << v.sat << ':' << v.minut << '\n';
	return os;
}
