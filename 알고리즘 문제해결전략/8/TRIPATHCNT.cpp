#include<iostream>
#include<algorithm>
using namespace std;
int height;
int map[100][100];
int cache[100][100];
int cache2[100][100];
int  cal(int x,int y)
{
	if (y == height - 1) return map[y][x];
	int& result = cache[y][x];
	if (result != -1) return result;
	result = map[y][x];
	result += max(cal(x + 1, y + 1), cal(x, y + 1));
	return result;
}
int count(int x, int y)
{
	if(y == height - 1) return 1;
	int& result = cache2[y][x];
	if (result != -1) return result;
	result = 0;
	if (cal(x, y + 1) <= cal(x + 1, y + 1)) result += count(x+1,y+1);
	if (cal(x, y + 1) >= cal(x+1 , y + 1)) result += count(x,y+1);
	return result;
}
int main()
{
	ios_base::sync_with_stdio(0);
//	cin.tie(0);
	int t,i,j;
	cin >> t;
	while (t--)
	{
		cin >> height;
		for (i = 0; i < height; i++)
			for (j = 0; j <= i; j++)
			{
				cin >> map[i][j];
				cache[i][j] = -1;
				cache2[i][j] = -1;
			}
		printf("%d\n",count(0,0));
	}
}
