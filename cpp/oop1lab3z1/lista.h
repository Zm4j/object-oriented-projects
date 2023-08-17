#pragma once

#include <iostream>
#include <vector>
#include <ostream>

using namespace std;

template <typename T>
class lista{
private:
	struct s {
		T podatak;
		s* next;
	};
	s* prvi=nullptr;
	s* tren=nullptr;
	s* posldnji = nullptr;
	int brelm = 0;

	void kopiraj(const lista& t);
	void brisi();
	void premesti(lista& t);

public:

	lista() {brelm = 0; }

	lista(const lista& t) { kopiraj(t); }
	lista(lista&& t) { premesti(t); }
	lista& operator=(const lista& t) {
		if (this != &t) {
			brisi();
			kopiraj(t);
		}
		return *this;
	}
	lista& operator=(lista&& t) {
		if (this != &t) {
			brisi();
			premesti(t);
		}
		return *this;
	}
	~lista() { brisi(); }

	void dodaj(T pod);
	int brojelemenata();
	void postavinaprvi();
	void sledecielement();
	bool postojitek() { return tren != nullptr; }
	T& uzmitek();
	
	void pisi() {
		s* temp = prvi;
		while (temp) {
			cout << temp->podatak;
			temp = temp->next;
		}
	}
};

class GreskaTek {};

template<typename T>
inline void lista<T>::kopiraj(const lista& t){
	brelm = t.brelm;
	s* temp1 = t.prvi;
	while (temp1) {
		if (prvi == nullptr) {
			prvi = new s;
			prvi->podatak = temp1->podatak;
			prvi->next = nullptr;
			posldnji = prvi;
			tren = prvi;
		}
		else {
			s* temp = new s;
			temp->next = nullptr;
			temp->podatak = temp1->podatak;
			posldnji->next = temp;
			posldnji = temp;
		}
		temp1 = temp1->next;
	}
}

template<typename T>
inline void lista<T>::brisi(){
	s* temp = prvi;
	while (temp) {
		s* temp1 = temp;
		temp = temp->next;
		delete(temp1);
	}
}

template<typename T>
inline void lista<T>::premesti(lista& t){
	brelm = t.brelm;
	prvi = t.prvi;
	tren = t.tren;
	posldnji = t.posldnji;
}

template<typename T>
inline void lista<T>::dodaj(T pod){
	if (prvi == nullptr) {
		prvi = new s;
		prvi->next = nullptr;
		prvi->podatak = pod;
		posldnji = prvi;
		tren = prvi;
	}
	else {
		s* temp = new s;
		temp->next = nullptr;
		temp->podatak = pod;
		posldnji->next = temp;
		posldnji = temp;
	}
	brelm++;
}

template<typename T>
inline int lista<T>::brojelemenata(){
	return brelm;
}

template<typename T>
inline void lista<T>::postavinaprvi(){
	tren = prvi;
}

template<typename T>
inline void lista<T>::sledecielement(){
	if (tren == nullptr) return;
	tren = tren->next;
}

template<typename T>
inline T& lista<T>::uzmitek(){
	try {
		if (!postojitek()) throw GreskaTek();
		cout << tren->podatak << endl;
		return tren->podatak;
	}
	catch (GreskaTek a){
		std::cout << "Greska";
	}
}
