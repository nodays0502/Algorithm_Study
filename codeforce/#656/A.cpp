
#include<iostream>
#include<algorithm>
using namespace std;
int num[2 * 100000];
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n;
		int maxi= 0;
		cin >> n;
		int i;
		for (i = 1; i <= n; i++)
		{
			cin >> num[i];
			if (num[i] > num[maxi]) maxi = i;
		}
		bool ok = true;
		int starti = 0;
		while(ok)
		{
			ok = false;
			for (i = maxi; i > starti; i--) // 2 1 3
			{//                                0 1 2
				if (num[i] < num[i - 1]) { ok = true; break; }
			}
			if (ok) { starti = i; continue; }
			for (i = maxi; i < n; i++)
			{
				if (num[i] < num[i + 1]) { ok = true; break; }
			}
			if (ok) 
			{
				starti = maxi+1;
				maxi = starti;
				for (i = starti; i <= n; i++)
				{
					if (num[maxi] < num[i]) maxi = i;
				}
			}
		}
		if (starti) cout << starti - 1 << endl;
		else cout << starti << endl;
	}
}
