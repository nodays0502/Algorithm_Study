#include<iostream>
#include<vector>
#include<algorithm>
#include<functional>
using namespace std;
long long cache[500001];
 
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
 
		int n;
		cin >> n;
		if (n == 1)
			cout << 0 << endl;
		else
		{
			long long result = 0;
			cache[1] = 8;
			for (int i = 2; i <= n / 2; i++)
			{
				cache[i] = cache[i - 1] + 8;
			}
			for (int i = 1; i <= n / 2; i++)
			{
				result += i * cache[i];
			}
			cout << result << endl;
		}
 
	}
}
