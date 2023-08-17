#include "posiljka.h"
#include "rukovodilac.h"

ostream& operator<<(ostream& os, const posiljka& p)
{
    os << "Posiljka[" << p.id << ", " << p.a.getnaziv() << "].\n";
    return os;
}

class GreskaG: public exception {
public:
    const char* what() const override {
        return "Nije obradjeno\n";
    }
};

class GreskaG1 : public exception {
public:
    const char* what() const override {
        return "Obradjeno je\n";
    }
};

void posiljka::operator+=(rukovodilac* r){
    try {
        if (obradjeno == 1) throw GreskaG1();
        list += r;
    }
    catch (GreskaG1 a) {
        cout << a.what();
    }
}

d posiljka::getdetalji() const
{
    try {
        if (obradjeno == 0) throw(GreskaG());
        return detalji;
    }
    catch (GreskaG a) {
        cout << a.what();
    }
}

void posiljka::menjajdetalje(int dan, double cena){
    detalji.brdana += dan;
    detalji.cena += cena;
}

void posiljka::izracunaj() {
    for (int i = 0; i < list.getbrojelm(); i++) {
        list[i]->obradaa(this);
    }
    obradjeno = 1;
}
