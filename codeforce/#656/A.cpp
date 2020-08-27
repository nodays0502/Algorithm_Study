#include<iostream>
 
#include<algorithm>
using namespace std;
int num[3];
int main()
{
	int t ;
	cin >> t;
	while (t--)
	{
		for (int i = 0; i < 3; i++)
		{
			cin >> num[i];
		}
		sort(&num[0], &num[3]);
		if (num[2] == num[1])
		{
			cout << "YES\n";
			printf("%d %d %d\n", num[2], num[0], 1);
		}
		else
		{
			cout << "NO\n";
		}
	}
}
