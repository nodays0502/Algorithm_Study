#include<iostream>
#include<cstring>
using namespace std;
int cache[101];
const int limit = 1000000007;
int cal(int n)
{
	int& result = cache[n];
	if (result != -1) return result;
	result = (cal(n - 1) + cal(n - 2))%limit;
	return result;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		memset(cache, -1, sizeof(cache));
		cache[1] = 1;
		cache[2] = 2;

		int n;
		cin >> n;
		cout << cal(n) << endl;
	}
}
