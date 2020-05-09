#include<iostream>
using namespace std;
int num[8000];
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int result = 0;
		int n;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cin>>num[i];
		}
		for (int i = 0; i < n; i++)
		{
			int si=0,se=1;
			int sum = num[si] + num[se];
			while (1)
			{
				if (sum > num[i])
				{
					sum -= num[si];
					si++;
					if (si >= n - 1) break;
				}
				else if (sum < num[i])
				{
					se++;
					if (se >= n) break;
					sum += num[se];
				}
				else {
					if (se > si) { result++; break; }
					sum -= num[si];
					si++;
					if (si >= n - 1) break;
				}
			}
		}
		printf("%d\n", result);
	}
}
