#include<iostream>
#include<cstring>
using namespace std;
const int limit = 10000000;
int cache[102][102];

int cal(int n,int first)
{
	if (n == first) return 1;
	int& result = cache[n][first];
	if (result != -1) return result;
	result = 0;
	for (int i = 1; i <= n - first; i++)
	{
		int temp = (i + first - 1);
		temp *= cal(n-first,i);
		temp %= limit;
		result += temp;
		result %= limit;
	}
	return result;
}
int main()
{
	int t;
	cin >> t;
	int temp;
	while (t--)
	{
		memset(cache, -1, sizeof(cache));
		cin >> temp;
		int sum = 0;
		for (int i = 1; i <= temp; i++)
		{
			sum += cal(temp, i);
			sum %= limit;
		}
		cout << sum << endl;
	}
}
