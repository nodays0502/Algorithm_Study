#include<iostream>
using namespace std;
const int limit = 15746;
int dp[1000001];

int main()
{
	int t;
	cin >> t;
	dp[1] = 1; // 1
	dp[2] = 2;  // 00  11
	dp[3] = 3;//  001 100 111
	dp[4] = 5; // 0000 0011 1001 11000 1111 
	for (int i = 5; i <= t; i++)
	{
		dp[i] = (dp[i - 1] + dp[i - 2])%limit;
	}
	cout << dp[t] << endl;
}
