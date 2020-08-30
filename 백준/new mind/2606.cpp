#include<iostream>
#include<queue>
#include<algorithm>
#include<cstring>
using namespace std;
bool map[101][101];
int cache[101];
int main()
{
	int com;
	int t;
	int count = 0;
	cin >> com >> t;
	for (int i = 0; i < t; i++)
	{
		int x,  y;
		cin >> x >> y;
		map[x][y] = true;
		map[y][x] = true;
	}
	queue<int> q;
	q.push(1);
	while (!q.empty())
	{
		int now=q.front();
		q.pop();
		int& result = cache[now];
		if (result != 0) continue;
		result = 1;
		count++;
		for (int i = 1; i <= com; i++)
		{
			if (map[now][i]) q.push(i);
		}
	}
	cout << count-1 << endl;
}
