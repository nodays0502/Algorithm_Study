#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int map[100][100];
int cache[100][100];
int cal(int x, int y, int line)
{
	if (y == line - 1) return map[y][x];
	else
	{
		int& result = cache[y][x];
		if (result != -1) return result;
		else
		{
			result = map[y][x];
			result += max(cal(x, y + 1, line), cal(x + 1, y + 1, line));
			return result;
		}
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
		for(int i =0;i<line;i++)
			for (int j = 0; j <= i; j++)
				cin >> map[i][j];
		cout << cal(0, 0, line) << "\n";
	}
}
