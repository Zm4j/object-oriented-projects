#pragma once

#include <iostream>
using namespace std;

class korisnik{
private:
	string ime;
	string adresa;
public:
	korisnik(string a, string b) : ime(a), adresa(b) {}

	korisnik& operator=(korisnik&& t) = delete;

	string getime() const { return ime; }
	string getadresa() const { return adresa; }

	friend ostream& operator<< (ostream& os, const korisnik& k);
};

