#include<iostream>
#include<cstring>
int map[51][51];
int cache[51][51];
using namespace std;
int numcount;
int movey[] = {1,0,-1,0};
int movex[] = { 0,1,0,-1 };

int t;
int M, N, K;
void dfs(int x,int y)
{
	if (x < 0 || x >= M || y < 0 || y >= N) return;
	if (map[y][x] == -1) return;
	int& result = cache[y][x];
	if (result != -1) return;
	result = numcount;
	map[y][x] = numcount;
	for (int i = 0; i < 4; i++)
	{
		dfs(x + movex[i], y + movey[i]);
	}

}
int main()
{
	memset(map, -1, sizeof(map));
	memset(cache, -1, sizeof(cache));
	cin >> t;
	while (t--)
	{
		numcount = 0;
		memset(map, -1, sizeof(map));
		memset(cache, -1, sizeof(cache));
		cin >> M >> N >> K;
		for (int i = 0; i < K; i++)
		{
			int x, y;
			cin >> x >> y;
			map[y][x] = 0;
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
			{
				if (map[i][j] == 0) {
					numcount++;
					dfs(j, i);
				}
			}
		cout << numcount << endl;
	}

}
