#include<iostream>
#include<cstring>
using namespace std;
int cache[101];
const int limit = 1000000007;
int cal(int x)
{
	int& result = cache[x];
	if (result != -1) return result;
	result = (cal(x - 1) + cal(x - 2))%limit;
	return result;
}
int main()
{
	int t;
	cin >> t;
	memset(cache, -1, sizeof(cache));
	cache[0] = 1;
	cache[1] = 1;
	cache[2] = 2;

	while(t--)
	{
		int n;
		cin >> n;
		int result;
		if (n == 1)
		{
			result = 1;
		}
		else if (n % 2 == 0)
		{
			result = cal(n);
			result = (result - cal(n / 2) + limit) % limit;
			result = (result - cal(n / 2 - 1) + limit) % limit;
		}
		else
		{
			result = (cal(n) - cal(n / 2)+limit)%limit;
		}
		cout << result<<endl;
	}
}
