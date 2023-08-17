#include "tacka.h"
#include <math.h>

double udaljenost(const tacka& t1, const tacka& t2){
	return sqrt((t1.x - t2.x) * (t1.x - t2.x) + (t1.y - t2.y) * (t1.y - t2.y));
}

bool operator==(const tacka& t1, const tacka& t2){
	return t1.x == t2.x && t1.y == t2.y;
}

ostream& operator<<(ostream& os, const tacka& t){
	os << '(' << t.x << ',' << t.y << ')';
	return os;
}
