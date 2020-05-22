#include <iostream>
using namespace std;

int main() {
	int h, m, h1, m1;
	cin >> h >> m;

	if (m >= 45) {
		h1 = h;
		m1 = m - 45;
	}
	else if(m<45&&h!=0) {
		h1 = h - 1;
		m1 = 60 + (m - 45);
	}
	else {
		h1 = 23;
		m1 = 60 + (m - 45);
	}
	cout << h1 << " " << m1 << endl;
	return 0;
}