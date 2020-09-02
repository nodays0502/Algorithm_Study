#include<iostream>
#include<cstring>

int dp[31][31];
using namespace std;
int com(int n,int r)
{
	if (n == r) return 1;
	if (r == 1) return n;
	int& result = dp[n][r];
	if (result != -1) return result;
	result = com(n - 1, r - 1) + com(n - 1, r);
	return result;
}
int main()
{
	int t;
	cin >> t;
	memset(dp, -1, sizeof(dp));
	while (t--)
	{
		int N, M;
		cin >> N >> M;
		cout<<com(M,N)<<endl;
	}
}
