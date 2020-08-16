#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
int N, M;
char map[101][101];
int cache[101][101];
const int INF = 987654321;
struct node {
	int y, x, count;
};
int movex[4] = {0,1,0,-1};
int movey[4] = {1,0,-1,0};
int main()
{
	cin >> N >> M;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> map[i][j];
	queue<node> q;
	q.push({ 0,0,1 });
	int answer = INF;
	while (!q.empty())
	{
		int nowy = q.front().y;
		int nowx = q.front().x;
		int count = q.front().count;
		q.pop();
		if (nowy == N - 1 && nowx == M - 1)
		{
			if (answer > count) answer = count;
			continue;
		}
		int& result = cache[nowy][nowx];
		if (result != 0 && result <= count) continue;
		result = count;
		for (int i = 0; i < 4; i++)
		{
			int newy = nowy + movey[i];
			int newx = nowx + movex[i];
			if (newx < 0 || newx >= M || newy < 0 || newy >= N || map[newy][newx]=='0') continue;
			q.push({ newy, newx, count + 1 });
		}
	}

	cout << answer << endl;
}
