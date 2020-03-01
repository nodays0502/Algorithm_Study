#include<iostream>
#include<queue>
using namespace std;
int map[100][100];
bool DP(int size)
{
	int x, y;
	queue<pair<int,int>> lists;
	lists.push({ 0, 0 });
	while (!lists.empty())
	{
		x = lists.front().first;
		y = lists.front().second;
		lists.pop();
		if (map[y][x] == 0) { return true; }
		else if (map[y][x] != -1 )
		{
			if(x + map[y][x]<size)
				lists.push({ x + map[y][x],y});
			if(y + map[y][x]<size)
				lists.push({ x,y + map[y][x]});
			map[y][x] = -1;
		}
	}
	return false;
}
int main()
{
	int t, size;
	cin >> t;
	while (t--)
	{
		cin >> size;
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				cin >> map[i][j];
			}
		}
		if (DP(size))
			cout << "YES\n";
		else
			cout << "NO\n";
	}
}
