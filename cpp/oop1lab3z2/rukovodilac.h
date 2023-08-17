#pragma once

#include <iostream>
#include "posiljka.h"

using namespace std;

class rukovodilac{
private:

public:
	virtual void obradaa(posiljka* p) = 0;
	virtual double izracunaj(artikal a) = 0;
};

