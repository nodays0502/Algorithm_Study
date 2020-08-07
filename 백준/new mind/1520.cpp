#include<iostream>
#include<cstring>
using namespace std;
int w, h;
int map[500][500];
int cache[500][500];
int movex[4] = { -1,0,1,0 };
int movey[4] = { 0,1,0,-1 };
int cal(int x,int y)
{
	if (x == w - 1 && y == h - 1) return 1;
	int& result = cache[y][x];
	if (result != -1) return result;
	result = 0;
	int newx, newy;
	for (int i = 0; i < 4; i++)
	{
		newx = x + movex[i];
		newy = y + movey[i];
		if (newx >= 0 && newx < w && newy >= 0 && newy < h && map[y][x] > map[newy][newx])
		{
			result += cal(newx, newy);
		}
	}
	return result;
}
int main()
{
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(0);
	cin >> h >> w;
	memset(cache, -1, sizeof(cache));
	for (int i = 0; i < h; i++)
		for (int j = 0; j < w; j++)
			cin >> map[i][j];
	cout << cal(0, 0) << endl;
	
}
