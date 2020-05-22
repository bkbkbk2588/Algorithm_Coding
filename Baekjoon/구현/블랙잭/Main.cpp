#include<iostream>
using namespace std;

int main() { 
	int n, m, temp = 0, minus, res = 0;
	int *card;
	cin >> n >> m;
	card = new int[n];
	minus = m;

	for (int i = 0; i < n; i++)
		cin >> card[i];

	for (int i = 0; i < n - 2; i++) {
		for (int k = i + 1; k < n - 1; k++) {
			for (int j = k+1; j < n; j++) {
				temp = card[i] + card[k] + card[j];
				if (((m - temp) >= 0) && ((m - temp) < minus)) {
					minus = m - temp;
					res = temp;
				}
			}
		}
	}
	cout << res << endl;
	delete[] card;
}