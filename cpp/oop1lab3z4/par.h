#pragma once

#include <iostream>

using namespace std;

template <typename T>
class par {
private:

	T* p1 = nullptr;
	T* p2 = nullptr;

	void kopiraj(const par& p);
	void brisi();
	void premesti(par&& p);

public:
	
	par(T a1, T a2) {
		p1 = new T(a1);
		p2 = new T(a2);
	}

	par(const par& p) { kopiraj(p); }
	par(par&& p) { premesti(p); }
	par& operator=(const par& p) {
		if (&p != this) {
			brisi();
			kopiraj(p);
		}
		return *this;
	}
	par& operator=(par&& p) {
		if (&p != this) {
			brisi();
			premesti(p);
		}
		return *this;
	}
	~par() { brisi(); }

	T& prvi() { return *p1; }
	T& drugi() { return *p2; }
	T& prvi() const { return *p1; }
	T& drugi() const { return *p2; }

	friend bool operator==(const par& pa1, const par& pa2) {
		return *pa1.prvi() == *pa1.prvi() && *pa2.drugi() == *pa2.drugi();
	}
	friend ostream& operator<<(ostream& os, const par& pa) {
		os << '[' << pa.prvi() << '-' << pa.drugi() << ']';
		return os;
	}
};

template<typename T>
inline void par<T>::kopiraj(const par& p){
	if(p.p1) p1 = new T(*p.p1);
	if(p.p2) p2 = new T(*p.p2);
}

template<typename T>
inline void par<T>::brisi(){
	p1 = nullptr;
	p2 = nullptr;
}

template<typename T>
inline void par<T>::premesti(par&& p){
	p1 = p.p1;
	p2 = p.p2;
}
