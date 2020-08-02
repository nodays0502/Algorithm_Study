#include<iostream>
#include<cstring>
using namespace std;

char map[5][5];
string word[10];
int cache[10][10][10];
int moving[][2] = { {0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1} };
bool cal(int i,int k,int x,int y)
{
	if (x < 0 || x >= 5 || y < 0 || y >= 5) return 0;
	if (k == word[i].length()-1 && map[y][x] == word[i][k]) return 1;
	int& result = cache[y][x][k];
	if (result != -1) return result;
	if (word[i][k] == map[y][x])
	{
		for (int j = 0; j < 8; j++)
		{
			result = cal(i, k + 1, x + moving[j][0], y + moving[j][1]);
			if (result) break;
		}
	}
	else return 0;
	return result;
}
int main()
{
	int t,count;
	cin >> t;
	while (t--)
	{
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				cin >> map[i][j];
		cin >> count;
		for (int i = 0; i < count; i++)
		{
			memset(cache, -1, sizeof(cache));
			cin >> word[i];
			bool ok = false;
			for (int k = 0; k < 5; k++)
			{
				for (int j = 0; j < 5; j++)
				{
					if (cal(i, 0, k, j))
					{
						cout << word[i] << " YES\n";
						ok = true;
						break;
					}
				}
				if (ok) break;
			}
			if (!ok) cout << word[i] << " NO\n";
		}
	}
}
