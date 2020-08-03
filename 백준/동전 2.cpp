#include<iostream>
#include<cstring>
#include<algorithm>
int cache[10000]; // 초기화 -1
int money[100];
using namespace std;
const int INF = 987654321;
int num, sum;
int cal(int now)
{
	if (sum == now) return 0;
	if (sum < now) return INF;
	int& result = cache[now];
	if (result != -1) return result;
	result = INF;
	for (int i = 0; i < num; i++)
	{
		result = min(result, cal(now + money[i]) + 1);
	}
	return result;
}
int main()
{
	int result = 0;
	memset(cache, -1, sizeof(cache));
	cin >>num >> sum;
	for (int i = 0; i < num; i++)
	{
		cin >> money[i];
	}
	result = cal(0);
	if (result >= INF) cout << -1 << endl;
	else cout << result << endl;
}
