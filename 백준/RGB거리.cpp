#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int cost[1001][3];
int cache[1001][3];
int t;
const int INF = 987654321;
int cal(int i,int select) 
{
	if (i == t - 1) return cost[i][select];
	int& result = cache[i][select];
	if (result != -1) return result;
	result = INF;
	for (int j = 0; j < 3; j++)
	{
		if(select != j)
			result = min(result, cal(i + 1, j));
	}
	result += cost[i][select];
	return result;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> t;
	memset(cache, -1, sizeof(cache));
	for (int i = 0; i < t; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			cin >> cost[i][j];
		}
	}
	int result = INF;
	for (int i = 0; i < 3; i++)
	{
		result = min(result, cal(0, i));
	}
	cout << result << endl;
}
