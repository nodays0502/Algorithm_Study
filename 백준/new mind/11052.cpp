#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int num[1000];
int cache[1000];
int t;
int dfs(int x)
{
	if (x == 0)return 0;
	int& result = cache[x];

	if (result != -1) return result;
	result = 0;
	for (int i = 1; i <= x; i++)
	{
		result = max(result,dfs(x - i)+num[i]);
	}
	return result;
}
int main()
{
	cin >> t;
	memset(cache, -1, sizeof(cache));
	for (int i = 1; i <= t; i++)
	{
		cin >> num[i];
	}
	cout << dfs(t) << endl;
}
