#include<iostream>
#include<deque>
using namespace std;
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n;
		cin >> n;
		if (n < 4)
			cout << -1;
		else 
		{
			deque<int> per;
			per.push_back(3);
			per.push_back(1);
			per.push_back(4);
			per.push_back(2);
			for (int i = 5; i <= n; i++)
			{
				if (i % 2 != 0)
				{
					per.push_back(i);
				}
				else
				{
					per.push_front(i);
				}
			}
			for (deque<int>::iterator i = per.begin(); i < per.end(); i++)
				cout << *i << " ";
		}
		cout << endl;
	}
}
