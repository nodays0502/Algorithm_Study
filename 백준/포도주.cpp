#include<iostream>
#include<algorithm>
using namespace std;
int cache[10001];
int wine[10001];
int main()
{
	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		cin >> wine[i];
	}
	cache[0] = wine[0];
	cache[1] = wine[0] + wine[1];
	for (int i = 2; i < t; i++)
	{
		cache[i] = max(cache[i - 1], max(cache[i - 2] + wine[i], cache[i - 3] + wine[i - 1] + wine[i]));
	}
	cout << cache[t - 1] << endl;
}
