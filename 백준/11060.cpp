#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int num[1001];
int cache[1001];
int t;
const int INF = 987654321;
int dfs(int now)
{
	if (now == t-1) return 0;
	int& result = cache[now];
	if (result != -1) return result;
	result = 0;
	int temp = INF;
	for (int i = num[now]; i >= 1; i--)
	{
		if(now+i<t)
			temp = min(temp, dfs(now + i)+1);
	}
	result = temp;
	return result;
}
int main()
{
	memset(cache, -1, sizeof(cache));
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		cin >> num[i];
	}
	int result = dfs(0);
	if (result >= INF) cout << -1 << endl;
	else cout << result << endl;

}
