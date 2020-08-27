#include<iostream>
#include<cstring>
using namespace std;
int num[51];
int temp[101];
int main()
{
	int t;
	cin >> t;
	while(t--)
	{
		int n;
		cin >> n;
		memset(num, 0, sizeof(num));
		for (int i = 0; i < 2*n; i++)
		{
			cin >> temp[i];
		}
		for (int i = 0; i < 2 * n; i++)
		{
			if (num[temp[i]] == 0) { num[temp[i]] = 1; cout<< temp[i] <<" "; }
		}
		cout << "\n";
	}
}
