#include<iostream>
#include<cstring>
using namespace std;
int map[100][100];
int cache[100][100];
int cal(int x, int y,int line)
{
	if (x >= line || y >= line) return 0;
	else if (x == line - 1 && y == line - 1) return 1;
	else
	{
		int& result = cache[y][x];
		if (result != -1) return result;
		else
		{
			result = cal(x+map[y][x], y,line) || cal(x, y+map[y][x],line);
		}
		return result;
	}
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		memset(cache, -1, sizeof(cache));
		int line;
		cin >> line;
		for (int i = 0; i < line; i++)
			for (int j = 0; j < line; j++)
				cin >> map[i][j];
		if (cal(0, 0, line))
			cout << "YES\n";
		else
			cout << "NO\n";
	}
}
