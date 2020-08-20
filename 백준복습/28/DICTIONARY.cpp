#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<vector<int>> alpha;
vector<int> order, visit;
void makeGraph(const vector<string>& words)
{
	alpha = vector<vector<int>>(26, vector<int>(26, 0));
	for (int i = 0; i < words.size()-1; i++)
	{
		int j = i + 1;
		int len = min(words[i].size(), words[j].size());
		for (int k = 0; k < len; k++)
		{
			if (words[i][k] != words[j][k])
			{
				int a = words[i][k] - 'a';
				int b = words[j][k] - 'a';
				alpha[a][b] = 1;
				break;
			}
		}
	}
}
void dfs(int here)
{
	visit[here] = 1;
	for (int i = 0; i < alpha.size(); i++)
		if (alpha[here][i] && !visit[i])
			dfs(i);
	order.push_back(here);
}
vector<int> topologicalSort()
{
	visit = vector<int>(26, 0);
	order.clear();

	for (int i = 0; i < alpha.size(); i++)
		if (!visit[i])
			dfs(i);
	reverse(order.begin(), order.end());
	for (int i = 0; i < alpha.size(); i++)
		for (int j = i + 1; j < alpha.size(); j++)
			if (alpha[order[j]][order[i]])
				return vector<int>();
	return order;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int N;
		cin >> N;
		vector<string>words(N);
		for (int i = 0; i < N; i++)
		{
			cin >> words[i];
		}
		makeGraph(words);
		
		vector<int> result = topologicalSort();
		if (result.empty())
			cout << "INVALID HYPOTHESIS";
		else
			for (int i = 0; i < result.size(); i++)
				cout << char(result[i] + 'a');
		cout << endl;
			
	}
}
