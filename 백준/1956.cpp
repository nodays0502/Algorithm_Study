#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int path[401][401];
int update[401][401];
int inf = 987654321;
struct node {
	int index;
	int length;
};
bool compare(node a, node b)
{
	return a.length < b.length;
}
void dij(int V);
int main()
{
	int V, E;
	int a, b, c;
	cin >> V >> E;
	for (int i = 1; i <= V; i++)
	{
		for (int j = 1; j <= V; j++)
		{
			if (i == j)
				path[i][i] = 0;
			else
				path[i][j] = inf;
		}
	}
	for (int i = 0; i < E; i++)
	{
		cin >> a >> b >> c;
		if(path[a][b] > c)
			path[a][b] = c;
	}
	dij(V);
}
void dij(int V)
{
	int minLength = inf;
	vector<node> list;
	for (int i = 1; i <= V; i++)
	{
		for (int j = 1; j <= V; j++)
		{
			if (path[i][j] < inf)
				list.push_back({ j,path[i][j] });
		}
		sort(list.begin(), list.end(), compare);
		for (int j = 0; j < list.size(); j++)
		{
			for (int k = 1; k <= V; k++)
				if (path[i][list[j].index] + path[list[j].index][k] < path[i][k])
					path[i][k] = path[i][list[j].index] + path[list[j].index][k];
		}
		list.clear();
		for (int j = 1; j <= V; j++)
		{
			if (path[j][i] < inf)
				list.push_back({ j,path[i][j] });
		}
		sort(list.begin(), list.end(), compare);
		for (int j = 0; j < list.size(); j++)
		{
			for (int k = 1; k <= V; k++)
				if (path[k][list[j].index] + path[list[j].index][i] < path[k][i])
					path[k][i] = path[k][list[j].index] + path[list[j].index][i];
		}
		list.clear();
	}
	
	for (int i = 1; i <= V; i++)
	{
		for (int j = 1; j <= V; j++)
		{
			if (i == j) continue;
			if (minLength > path[i][j] + path[j][i])
				minLength = path[i][j] + path[j][i];
		}
	}
	if (minLength >= inf) cout << "-1";
	else
		cout << minLength;
}
