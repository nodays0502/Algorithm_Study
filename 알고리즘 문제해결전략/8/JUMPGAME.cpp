#include<iostream>
#include<cstring>
using namespace std;
int map[100][100];
int n;
int cache[100][100];
int solve(int x, int y) {
	if (x >= n || y >= n) return 0;
	if(x == n - 1 && y == n - 1) return 1;
	int& result = cache[y][x];
	if (result != -1) return result;
	result = solve(x + map[y][x], y) || solve(x, y+map[y][x]);
	return result;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		memset(cache, -1, sizeof(cache));
		cin >> n;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				cin >> map[i][j];
		if (solve(0, 0))
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}
}
