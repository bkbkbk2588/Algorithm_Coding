#include<iostream>
#include<string>

using namespace std;

int main() {
	string str;
	int max = 0;
	int arr[26] = { 0 }, x;
	char a;

	getline(cin, str);
	for (int i = 0; i < str.length(); i++) {
		if (str[i] >= 65 && str[i] <= 90) {
			arr[str[i] - 65] += 1;
		}
		else if (str[i] >= 97 && str[i] <= 122) {
			arr[str[i] - 97] += 1;
		}
	}
	for (int i = 0; i < 26; i++) {
		if (arr[i] > max) {
			max = arr[i];
			x = i;
			a = (char)(x + 65);
		}
		else if (arr[i]==max) {
			a = '?';
		}
	}
	cout << a << endl;	
}