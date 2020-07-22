#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int cache[100][100];
int map[100][100];
int value[100][100];
int cal2(int x, int y, int& line)
{
	if (y == line - 1) return map[y][x];
	int& result = value[y][x];
	if (result != -1) return result;
	result = map[y][x] + max(cal2(x, y + 1, line), cal2(x + 1, y + 1, line));
	return result;
}
int cal(int x,int y,int& line)
{
	if (y == line - 1) return 1;
	int& result = cache[y][x];
	if (result != -1) return result;
	result = 0;
	if (cal2(x, y, line)==map[y][x]+cal2(x, y + 1, line)) result += cal(x, y + 1, line);
	if (cal2(x, y, line)==map[y][x]+cal2(x+1, y + 1, line)) result += cal(x+1, y + 1, line);
	return result;
}

int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int line;
		cin >> line;
		memset(cache, -1, sizeof(cache));
		memset(value,-1,sizeof(value));
		for(int i=0;i<line;i++)
			for (int j = 0; j <= i; j++)
			{
				cin >> map[i][j];
			}
		cout<<cal(0, 0,line)<<endl;
	}
}
