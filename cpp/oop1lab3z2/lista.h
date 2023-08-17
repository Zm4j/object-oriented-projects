#pragma once

#include <iostream>
#include <exception>
using namespace std;

class GreskaIndeksiranje : public exception {
public:
	const char* what() const override {
		return "Indeks van granica\n";
	}
};

template <typename T>
class lista {
private:

	struct s {
		T podatak;
		s* next;

		s(const T& pod) : podatak(pod) {}
	};
	s* prvi;
	s* poslednji;
	int brelm = 0;

	void kopiraj(const lista& l);
	void brisi();
	void premesti(lista& l);

public:

	lista() {
		prvi = nullptr;
		poslednji = nullptr;
	};

	lista(const lista& l) { kopiraj(l); }
	lista(lista&& l) { premesti(l); }
	lista& operator= (const lista& l) {
		if (&l != this) {
			brisi();
			kopiraj();
		}
		return l;
	}
	lista& operator=(lista&& l) {
		if (&l != this) {
			brisi();
			premesti();
		}
		return l;
	}
	~lista() { brisi(); }

	void operator+=(const T& pod) {
		if (prvi == nullptr) {
			prvi = new s(pod);
			prvi->podatak = pod;
			prvi->next = nullptr;
			poslednji = prvi;
		}
		else {
			s* temp = new s(pod);
			temp->podatak = pod;
			temp->next = nullptr;
			poslednji->next = temp;
			poslednji = temp;
		}
		brelm++;
	}

	int getbrojelm() const { return brelm; }

	T operator[](int ind) const {
		try {
			if (ind < 0 || ind >= brelm) throw GreskaIndeksiranje();
			s* temp = prvi;
			for (int i = 0; i < ind; i++) temp = temp->next;
			return temp->podatak;
		}
		catch (GreskaIndeksiranje a) {
			cout << a.what();
		}
	}
};

template<typename T>
inline void lista<T>::kopiraj(const lista& l) {
	brelm = l.brelm;
	s* temp = l.prvi;
	while (temp) {
		if (prvi == nullptr) {
			prvi = new s(temp->podatak);
			prvi->podatak = temp->podatak;
			prvi->next = nullptr;
			poslednji = prvi;
		}
		else {
			s* temp1 = new s(temp->podatak);
			temp1->podatak = temp->podatak;
			temp1->next = nullptr;
			poslednji->next = temp1;
			poslednji = temp1;
		}
	}
}

template<typename T>
inline void lista<T>::brisi() {
	s* temp = prvi;
	while (temp) {
		s* temp1 = temp;
		temp = temp->next;
		delete(temp1);
	}
}

template<typename T>
inline void lista<T>::premesti(lista& l) {
	prvi = l.prvi;
	brelm = l.brelm;
	poslednji = l.poslednji;
}
