#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
const int dSize = 200000;
int num[dSize];
int noChange[2*dSize+1];
int sum[2*dSize];
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int t;
	cin >> t;
	while (t--)
	{
		int n, k;
		cin >> n >> k;
		for (int i = 0; i <= 2 * k; i++)
		{
			noChange[i] = 0;
			sum[i] = 0;
		}
		for (int i = 1; i <= n; i++)
		{
			cin >> num[i];
		}
		for (int i = 1; i <= n / 2; i++)
		{
			noChange[min(num[i], num[n - i + 1]) + 1]--;
			noChange[max(num[i], num[n - i + 1]) + k + 1]++; // 이 사이 구간은 횟수가 1 줄어든다.
		}
		for (int i = 2; i <= 2*k+1; i++)
		{
			noChange[i] += noChange[i - 1];
		}
		for (int i = 1; i <= n / 2; i++)
		{
			sum[num[i] + num[n - i + 1]]--; // 이 부분만 횟수가	1번 빠진다.
		}
		int result = n;
		for (int i = 1; i <= 2*k; i++)
		{
			result = min(result, n + noChange[i] + sum[i]);
		}
		cout << result << "\n";
	}
}
