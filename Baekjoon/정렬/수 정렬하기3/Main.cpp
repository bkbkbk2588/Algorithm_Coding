#include <iostream>
using namespace std;
 
const int MAX = 10000 + 1;
 
int N;
int arr[MAX];
 
void ascendingOrder(void)
{
        //누적 합
        for (int i = 1; i < MAX; i++)
                 arr[i] += arr[i - 1];
 
        for (int i = 1; i < MAX; i++)
        {
                 //arr[i]-arr[i-1]은 i가 입력된 횟수
                 int idx = arr[i] - arr[i - 1];
                 while (idx--)
                         //cout << i << endl;
                         printf("%d\n", i);
        }
}
 
int main(void)
{
        cin >> N;
 
        for (int i = 0; i < N; i++)
        {
                 int num;
                 //cin >> num;
                 scanf("%d", &num);
                 arr[num]++;
        }
 
        ascendingOrder();
        return 0;
}