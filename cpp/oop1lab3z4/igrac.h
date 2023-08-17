#pragma once

#include <iostream>

using namespace std;

class igrac{
private:

	string ime;
	int broj;

public:

	igrac(string ime, int broj = 1000) : ime(ime), broj(broj) {}

	int getbroj() const { return broj; }
	string getime() const { return ime; }
	void menjajvrednost(double procenat);
	friend bool operator==(const igrac& i1, const igrac& i2);
	friend ostream& operator<<(ostream& os, const igrac& i);
	

};

