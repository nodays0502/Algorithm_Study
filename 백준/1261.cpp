#include<iostream>
#include<queue>
using namespace std;
int result[101][101];
int map[101][101];
const int inf = 987654321;
int moveX[4] = {1,-1,0,0};
int moveY[4] = { 0,0,1,-1 };
void BFS(int m, int n)
{
	int x, y;
	int curx, cury;
	int count;
	queue<pair<int, int>> node;
	node.push({ 1, 1 });
	while (!node.empty())
	{
		x = node.front().first;
		y = node.front().second;
		node.pop();
		for (int i = 0; i < 4; i++)
		{
			count = result[x][y];
			curx = x + moveX[i];
			cury = y + moveY[i];
			if (1 <= curx && curx <= m && 1 <= cury && cury <= n && result[curx][cury] > count)
			{
				if (map[curx][cury] == 1 && result[curx][cury] > count+1 ) { result[curx][cury] = count + 1; node.push({ curx, cury });
				}
				else if (map[curx][cury] == 0 && result[curx][cury] > count) { result[curx][cury] = count; node.push({ curx, cury });
				}
				
			}
		}
	}
}
int main()
{
	int n, m;
	char ch;
	cin >> n >> m;
	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			result[i][j] = inf;
		}
	}
	result[1][1] = 0;
	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			cin >> ch;
			map[i][j] = ch - '0';
		}
	}

	BFS(m,n);

	cout << result[m][n];
}
