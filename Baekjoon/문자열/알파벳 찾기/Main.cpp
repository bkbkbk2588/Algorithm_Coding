#include<iostream>
#include<string>
using namespace std;

int main() {
	string a;
	int x=0;

	cin >> a;

	for (int j =97; j <= 122; j++) {
		for (int i = 0; i < a.length(); i++) {
			if ((char)j == a[x]) {
			}
			else {
				if ((char)j == a[i]) {
					x = i;
				}
			}
		}
		if ((char)j == a[x]) {
			cout << x << " ";
		}
		else
			cout << "-1 ";
	}
	cout << endl;
}