#pragma once

#include "tim.h"
#include <exception>

class GreskaPTim: public exception{
public:
	const char* what() const override {
		return "GRESKA IGRAC NEMA DOVOLJNO VELIKI SKIL LOL\n";
	}
};

class privilegovantim : public tim{
private:
	int minimalna;
public:
	privilegovantim(string ime, int maksbrojigraca, int min);

	virtual void prikljuci(const igrac& igr, const int& ind) override;
	virtual string pisi() const override;
};

