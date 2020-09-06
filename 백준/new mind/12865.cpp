#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int cache[101][100002];
int weight[101];
int value[101];
const int INF = 987654321;
int N, K;
int dfs(int now, int bag)
{
	if (bag < 0) return -INF;
	if (now == N) return 0;

	int& answer = cache[now][bag];
	if (answer != -1) return answer;
	answer = max((dfs(now + 1, bag - weight[now])+value[now]), dfs(now + 1, bag));
	return answer;
}
int main()
{
	memset(cache, -1, sizeof(cache));
	cin >> N >> K;
	for (int i = 0; i < N;i++)
	{
		cin >> weight[i] >> value[i];
	}
	cout << dfs(0, K) << endl;
}
