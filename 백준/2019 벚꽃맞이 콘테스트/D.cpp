#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
char mapss[1000][1000];
int cache[1000][1000];
int N, M;
int moves[3] = { -1,0,1 };

int main()
{
	ios::sync_with_stdio();
	cin.tie();
	memset(cache, -1, sizeof(cache));
	cin >> N >> M;
	int rx, ry,x,y;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
		{
			cin >> mapss[i][j];
			if (mapss[i][j] == 'R') { rx = j; ry = i; cache[ry][rx] = 0; }
		}
	int result = -1;
	for (int x = rx+1, sy = ry, ey = ry; x < M; x++)
	{
		if (sy - 1 >= 0) sy--;
		if (ey + 1 < N) ey++;
		for (int y = sy; y <= ey; y++)
		{
			if (mapss[y][x] == '#') continue;
			if (cache[y][x - 1] != -1) cache[y][x]= max(cache[y][x], cache[y][x - 1]);
			if (y - 1 >= 0 && cache[y - 1][x - 1] != -1)  cache[y][x] = max(cache[y][x], cache[y - 1][x - 1]);
			if (y + 1 < N && cache[y + 1][x - 1] != -1)cache[y][x] = max(cache[y][x], cache[y+1][x - 1]);
			if (mapss[y][x] == 'C' && cache[y][x]!=-1) cache[y][x]++;
			if (mapss[y][x] == 'O' && cache[y][x] != -1) result = max(result, cache[y][x]);
		}
	}
	cout << result;
}
