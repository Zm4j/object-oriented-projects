#include "vozilo.h"

double vozilo::cenaputa(put& p) const{
    return cena + jedinica * p.predjeniput();
}

ostream& operator<<(ostream& os, const vozilo& v){
    os << v.model;
    return os;
}
