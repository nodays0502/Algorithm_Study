#include<iostream>
#include<algorithm>
using namespace std;
int num[1001];
int dp[1001];
int main()
{
	int t;
	int result = 1;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		cin >> num[i];
	}
	dp[t - 1] = 1;
	for (int i = t - 2; i >= 0; i--)
	{
		int MAX = 0;
		for (int j = t - 1; j > i; j--)
		{
			if(num[i] > num[j])
				MAX = max(MAX, dp[j]);
		}
		dp[i] = MAX + 1;
		if (result < dp[i]) result = dp[i];
	}
	cout << result << endl;
}
