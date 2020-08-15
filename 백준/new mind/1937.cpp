#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int map[501][501];
int cache[501][501];
int t;
const int INF = 987654321;
int movey[4] = {1,0,-1,0};
int movex[4] = {0,1,0,-1};
int cal(int y,int x)
{
	int& result = cache[y][x];
	if (result != -1) return result;
	result = 1;
	for (int i = 0; i < 4; i++)
	{
		int newx = x + movex[i];
		int newy = y + movey[i];
		if (y<0 || y>t || x<0 || x>t) continue;
		if(map[newy][newx]> map[y][x])
			result = max(result,cal(newy,newx)+1);
	}
	return result;
}
int main()
{
	cin >> t;
	for (int i = 0; i < t; i++)
		for (int j = 0; j < t; j++)
			cin >> map[i][j];
	int result = 0;
	memset(cache, -1, sizeof(cache));
	for (int i = 0; i < t; i++)
		for (int j = 0; j < t; j++)
		{
			result = max(result, cal(i, j));
		}
	cout << result << endl;

}
