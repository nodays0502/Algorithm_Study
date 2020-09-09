#include<iostream>
#include<cstring>
#include<algorithm>
#include<queue>
using namespace std;
char map[51][51];
int cache[51][51];
struct node{
	int y;
	int x;
	char D;
};
int movey[4] = {1,0,-1,0};
int movex[4] = { 0,1,0,-1 };
int main()
{
	int R, L;
	cin >> L >> R;
	int sx, sy;
	queue<node> q;
	for (int i = 0; i < L; i++)
		for (int j = 0; j < R; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == '*')
				q.push({ i,j,map[i][j] });
			else if (map[i][j] == 'S')
			{
				sx = j; sy = i;
			}
		}
	int count = 0;
	int result = 0; // 0 : 아직 1: 도착 -1 : 절대 불가
	q.push({ sy,sx,'S'});
	while (!q.empty() && result == 0)
	{
		int ny = q.front().y;
		int nx = q.front().x;
		char nD = q.front().D;
		int count = cache[ny][nx];
		q.pop();
		int newx, newy;
		if (nD != 'S')
		{
			for (int i = 0; i < 4; i++)
			{
				newx = nx + movex[i];
				newy = ny + movey[i];
				if (newx >= 0 && newx < R && newy >= 0 && newy < L && map[newy][newx] != 'X' && map[newy][newx] != '*' && map[newy][newx] != 'D')
				{
					q.push({ newy,newx,nD});
					map[newy][newx] = '*';
				}
			}
		}
		else
		{
			if (map[ny][nx] == 'D') { result = count; }
				for (int i = 0; i < 4; i++)
				{
					newx = nx + movex[i];
					newy = ny + movey[i];
					if (newx >= 0 && newx < R && newy >= 0 && newy < L && map[newy][newx] != 'X' && map[newy][newx] != '*' && cache[newy][newx] == 0)
					{
						q.push({ newy,newx,nD});
						cache[newy][newx] = count + 1;
					}
				}
			
		}
	}
	if (result == 0)
		cout << "KAKTUS" << endl;
	else
		cout << result << endl;
}
