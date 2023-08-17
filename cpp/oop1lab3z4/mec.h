#pragma once

#include "privilegovantim.h"
#include "par.h"

enum ishodmec { POBEDA_DOMACIN=0, NERESENO=1, POBEDA_GOST=2 };

class GreskaMec : public exception {
public:
	const char* what() const override {
		return "MEC NIJE ODIGRAN\n";
	}
};

class mec{
private:
	
	par<tim*> timovi;
	ishodmec ishodi;

	bool odigran=0;

public:

	mec(par<tim*> timovi) : timovi(timovi) {}

	void odigraj();
	bool dalijeodigran() const { return odigran; }
	par<int> ishod() const;
	friend ostream& operator<<(ostream& os, const mec& m);

};

