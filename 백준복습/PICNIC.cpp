#include<iostream>
#include<cstring>
using namespace std;
bool friends[10][10];
bool match[10];
int cal(int n,int now)
{
	int result = 0;
	if (now == n) return 1;
	if (match[now] != true)
	{
		for (int i = 0; i < n; i++)
		{
			if (friends[now][i] && match[i] != true) {
				match[now] = true;
				match[i] = true;
				result += cal(n, now + 1);
				match[now] = false;
				match[i] = false;
			}
			
		}
	}
	else result += cal(n,now+1);
	return result;
}

int main()
{

	int t;
	cin >> t;
	int n, m;
	while (t--)
	{
		memset(friends, false, sizeof(friends));
		cin >> n >> m;
		int x, y;
		for (int i = 0; i < m; i++)
		{
			cin >> x >> y;
			friends[x][y] = true;
			friends[y][x] = true;
		}
		cout << cal(n, 0) << endl;
	}
}
