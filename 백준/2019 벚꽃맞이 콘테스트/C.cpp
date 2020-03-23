#include<iostream>
#include<queue>
using namespace std;
char map[3000][3000];
int now[3000][3000];
int BFS(int n, int m,int x,int y);
int xadd[4] = {-1,0,1,0};
int yadd[4] = { 0,-1,0,1 };
struct node {
	int x;
	int y;
	int count;
};
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	int n, m;
	int x, y;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == '2')
			{
				y = i;
				x = j;
			}
		}
	}
	int result = BFS(n, m, x, y);
	if (result == -1) cout << "NIE\n";
	else cout << "TAK\n"<< result << "\n";
}
int BFS(int n, int m, int x, int y)
{
	int nowx;
	int nowy;
	int result;
	queue<node> qu;
	qu.push({x, y, 0});
	while (!qu.empty())
	{
		nowx = qu.front().x;
		nowy = qu.front().y;
		result = qu.front().count;
		qu.pop();
		if (map[nowy][nowx] == '3' || map[nowy][nowx] == '4' || map[nowy][nowx] == '5')
			return result;
		else if ((map[nowy][nowx] == '0' || map[nowy][nowx]=='2')&&now[nowx][nowy] == 0)
		{
			result++;
			for (int i = 0; i < 4; i++)
			{
				if (nowx + xadd[i] >= 0 && nowx + xadd[i] < m && nowy + yadd[i] >= 0 && nowy + yadd[i] < n && map[nowy+yadd[i]][nowx+xadd[i]] != '1')
					qu.push({ nowx + xadd[i], nowy + yadd[i], result });
			}
		}
		else;
		now[nowx][nowy] = 1;
	}
	return -1;
}
//	ios::sync_with_stdio(false);
//	cin.tie(0); 를 통해 속도 
