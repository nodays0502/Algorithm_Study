#include<iostream>
using namespace std;
int cache[100];
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n, k;
		cin >> n >> k;
		if (k > n) cout << "NO" << endl;
		else if (k % 2 == 0 && (n % 2) != 0)cout << "NO" << endl;
		else
		{
			int sum = 0;
				for (int i = 0; i < k-1; i++)
				{
					sum += 1;
					cache[i] = 1;
				}
				if ((n - sum) % 2 == 0)
				{
					sum = 0;
					for (int i = 0; i < k - 1; i++)
					{
						sum += 2;
						cache[i] = 2;
					}
					if ((n - sum) % 2 == 0 && (n - sum)>0)
					{
						cout << "YES" << endl;
							cache[k - 1] = n - sum;
						for (int i = 0; i < k; i++)
						{
							cout << cache[i] << " ";
						}
					}
					else {
						cout << "NO" << endl;
					}
				}
				else
				{
					cache[k - 1] = n - sum;
					cout << "YES" << endl;
					for (int i = 0; i < k; i++)
					{
						cout << cache[i] << " ";
					}
				}
			
 
		}
	}
}
