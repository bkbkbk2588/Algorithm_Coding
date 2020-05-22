#include<iostream>
#include<string>
using namespace std;

int main() {
	string a;
	int y=1;
	int count = 0;


	getline(cin, a);
	
	for (int i = 0; i < a.length(); i++) {
		if (a[i]==' ') {
			y = 1;
		}
		else if (y) {
			y = 0;
			count++;
		}
	}
	cout << count << endl;
}