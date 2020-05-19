#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int map[100][100];
int cache[100][100];
int n;
int cal(int x, int y)
{
	if (y >= n) return 0;
	if (y == n - 1) return map[y][x];
	int& result = cache[y][x];
	if (result != -1) return result;
	result = map[y][x];
	result += max(cal(x + 1, y + 1), cal(x, y + 1));
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
			for (int j = 0; j <= i; j++)
				cin >> map[i][j];
		cout << cal(0, 0) << endl;
	}
}
