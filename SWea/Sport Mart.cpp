#include<iostream>
using namespace std;
int temp[1000];
int main()
{
	cin.tie(0);
	ios::sync_with_stdio(false);
	int num;
	cin >> num;
	int N, M;
	long long maxProfit;
	int tempsum;
	for (int i = 0; i < num; i++)
	{
		maxProfit = -1;
		cin >>N>>M;
		for (int j = 0; j < N; j++)
		{
			cin >> temp[j];
		}
		for (int j = 0; j < N-1; j++)
		{
			for (int k = j+1; k < N; k++)
			{
				tempsum = temp[j] + temp[k];
				if (tempsum <= M && tempsum > maxProfit) maxProfit = tempsum;
			}
		}
		cout << "#" << i + 1 << " " << maxProfit << endl;
	}
}//
