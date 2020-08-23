#include<iostream>
#include<algorithm>
#include<cstring>
#include<vector>
#pragma warning(disable:4996)
using namespace std;
int t;
int map[25][25];
int cache[25][25];
int movey[4] = {1,0,-1,0};
int movex[4] = {0,1,0,-1};
int Rcount = 1;
int dfs(int x,int y)
{
	int& result = cache[y][x];
	if (result != 0) return result;
	result = 1;
	map[y][x] = Rcount;
	for (int i = 0; i < 4; i++)
	{
		int newx = x + movex[i];
		int newy = y + movey[i];
		if (newx >= 0 && newx < t && newy >= 0 && newy < t && map[newy][newx] == 1)
			result += dfs(newx, newy);
	}
	return result;
}
int main()
{
	cin >> t;
	vector<int> result;
	for (int i = 0; i < t; i++)
		for (int j = 0; j < t; j++)
			scanf("%1d", &map[i][j]);
	for (int i = 0; i < t; i++)
		for (int j = 0; j < t; j++)
		{
			if (map[i][j] == 1) { Rcount++; result.push_back(dfs(j, i)); }
		}
	sort(result.begin(), result.end());
	cout << result.size() << endl;
	for (int i = 0; i < result.size(); i++)
		cout << result[i] << endl;
}
