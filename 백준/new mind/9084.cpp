#include<iostream>
#include<cstring>
using namespace std;
int money[20];
int DP[10001][21];
int N, M;
const int INF = 987654321;
int dfs(int now,int value)
{
	if (value == 0) return 1;
	if (value < 0 || now >= N) return 0;

	int& result = DP[value][now];
	if (result != -1) return result;
	result = 0;
	for (int i = 0; value - money[now]*i >= 0; i++)
	{
		result += dfs(now + 1, value - money[now] * i);
	}
	return result;
}
int main()
{
	int t;

	cin >> t;
	while (t--)
	{
		memset(DP, -1, sizeof(DP));
		cin >> N;
		for (int i = 0; i < N; i++)
			cin >> money[i];
		cin >> M;
		cout<<dfs(0, M) << endl;
	}
}
