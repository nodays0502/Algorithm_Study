#include<iostream>
using namespace std;
unsigned long long INF = -1;
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n, k;
		int count = 0;
		cin >> n >> k;
		int prenum = k;
		int nownum = k + k/n;
		int temp;
		while (nownum/n != prenum/n)
		{
			temp = prenum;
			prenum = nownum;
			nownum += (nownum / n - temp/ n);
		}
 
		cout << nownum << endl;
	}
}
