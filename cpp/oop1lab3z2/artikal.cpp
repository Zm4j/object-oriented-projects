#include "artikal.h"

bool operator==(const artikal& a, const artikal& b){
	return a.getbarkod()==b.getbarkod();
}
