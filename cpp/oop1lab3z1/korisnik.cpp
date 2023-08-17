#include "korisnik.h"

ostream& operator<<(ostream& os, const korisnik& k){
    os << '(' << k.ime << ')' << k.adresa << ".\n";
    return os;
}
