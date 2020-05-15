#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n, k;
		string s;

		cin >> n >> k>>s;
		int sum=0;
		vector<vector<int>> a;
		a.resize(k);
		for (int i = 0; i < n; i++)
		{
			a[i % k].push_back(s[i]-'0');
			if (s[i] == '1') sum += 1;
		}
		int longest = 0;
		for (int i = 0; i < a.size(); i++)
		{
			int cur = 0;
			int now = 0;
			for (int j = 0; j < a[i].size(); j++)
			{
				if (a[i][j] == 0) cur = -1;
				else cur = 1;

				now = max(0, now + cur);
				longest = max(longest, now);
			}
		}
		cout << sum - longest << endl;
	}
}
