#include<iostream>
#include<cstring>
using namespace std; 
int map[101][101];
long long cache[101][101];
int t;
long long  cal(int x, int y)
{
	if (x<0 || x >= t || y < 0 || y >= t) return 0;
	if (x == t - 1 && y == t - 1) return 1;
	long long& result = cache[y][x];
	if (result != -1) return result;
	result = 0;
	int value = map[y][x];

	if (value == 0) return 0;
	result += (cal(x + value, y)+cal(x,y+value));
	return result;
}
int main()
{
	cin >> t;
	memset(cache, -1, sizeof(cache));
	for (int i = 0; i < t; i++)
		for (int j = 0; j < t; j++)
			cin >> map[i][j];

	long long result = cal(0, 0);
	cout << result << endl;
}
