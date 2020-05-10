#include<iostream>
using namespace std;
int num[200000];
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n;
		int result[2] = {0,};
		cin >> n;
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			cin >> num[i];
			sum += num[i];
		}
		int si = -1, se = n;
		int tempsum = 0;
		int presum = 0;
		bool ok = true; // true일떄 si ++;
		int count = 0;
		while (se - si >1)
		{
			tempsum = 0;
			count++;
			while (presum >= tempsum && se - si > 1)
			{
				if (ok) 
				{
					si++;
					tempsum += num[si];
				}
				else
				{
					se--;
					tempsum += num[se];
				}
			}
			if (ok) { result[0] += tempsum; }
			else { result[1] += tempsum; }
			ok = !ok;
			presum = tempsum;
		}
		printf("%d %d %d\n",count, result[0], result[1]);
	}
}
