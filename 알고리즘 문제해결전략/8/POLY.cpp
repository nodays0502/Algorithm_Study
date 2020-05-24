#include<iostream>
#include<cstring>
using namespace std;
int cache[101][101];
const int limit = 10000000;
int cal(int n,int first)
{
	if (n == first) return 1;
	int& result = cache[n][first];
	if (result != -1) return result;
	result = 0;
	for (int i = 1; i <= n-first; i++)
	{
		int add = i + first - 1;
		add *= cal(n - first, i);
		add %= limit;
		result += add;
		result %= limit;
	}
	return result;
}
int main()
{
	int t;
	cin >> t;
	memset(cache, -1, sizeof(cache));
	while (t--)
	{
//		
		int n;
		cin >> n;
		int result = 0;
		for (int i = 1; i <= n; i++)
		{
			result+=cal(n, i);
			result %= limit;
		}
		cout << result << endl;
	}
}
