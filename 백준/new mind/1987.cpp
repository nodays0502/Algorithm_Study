#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int R, N;
//int cache[20][20];
char map[20][20];
int movey[4] = {1,0,-1,0};
int movex[4] = {0,1,0,-1};
int result = 0;
void dfs(int x,int y,int check,int count)
{
	if ((check | (1 << (map[y][x] - 'A'))) == check)
	{
		return ;
	}
	count++;
	check = check | (1 << (map[y][x] - 'A'));

	if (result < count) result = count;
	for (int i = 0; i < 4; i++)
	{
		int newx = x + movex[i];
		int newy = y + movey[i];
		if (newx >= 0 && newx < N && newy >= 0 && newy < R)
		{
			dfs(newx, newy, check,count);
		}
	}
}
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> R >> N;
	for (int i = 0; i < R; i++)
		for (int j = 0; j < N; j++)
			cin >> map[i][j];
	dfs(0, 0, 0, 0);
	cout << result << "\n";
}
