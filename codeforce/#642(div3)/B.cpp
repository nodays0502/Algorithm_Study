#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n, k;
		cin >> n >> k;
		vector<int >a;
		vector<int>b;
		int temp;
		for (int i = 0; i < n; i++)
		{
			cin >> temp;
			a.push_back(temp);
		}
		for (int i = 0; i < n; i++)
		{
			cin >> temp;
			b.push_back(temp);
		}
		sort(a.begin(), a.end(),greater<int>());
		sort(b.begin(), b.end(),greater<int>());
		int result = 0;
		int ai = 0, bi = 0;
		for (int i = 0; i < n; i++)
		{
			if (a[ai] < b[bi] && k)
			{
				result += b[bi];
				k --;
				bi++;
			}
			else
			{
				result += a[ai];
				ai++;
			}
		}
		cout << result<<endl;
	}
}
