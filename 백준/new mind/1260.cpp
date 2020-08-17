#include<iostream>
#include<cstring>
#include<queue>
using namespace std;
int N, M, V;
bool map[1001][1001];
bool cache1[1001];
bool cache2[1001];
void DFS(int num)
{
	if (cache1[num] == 0)
	{
		cache1[num] = 1;
		cout << num << " ";
		for (int i = 1; i <= N; i++)
		{
			if (map[num][i])
			{
				DFS(i);
			}
		}
	}
}
void BFS(int num)
{
	queue<int> q;
	q.push(num);
	while (!q.empty())
	{
		int now = q.front();
		q.pop();
		if (cache2[now]==0)
		{
			cache2[now] = 1;
			cout << now << " ";
			for (int i = 1; i <= N; i++)
			{
				if (map[now][i])
				{
					q.push(i);
				}
			}
		}
	}
}
int main()
{
	cin >> N >> M >> V;
	int temp1, temp2;
	for (int i = 0; i < M; i++)
	{
		cin >> temp1 >> temp2;
		map[temp1][temp2] = 1;
		map[temp2][temp1] = 1;
	}
	DFS(V);
	cout << endl;
	BFS(V);
}
