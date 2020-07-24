#include<iostream>
#include<vector>
#include<list>
#include<algorithm>
using namespace std;

int main()
{
	int t;
	cin >> t;
	int N, K;
	while (t--)
	{
		cin >> N >> K;
		list<int> people;
		for (int i = 1; i <= N; i++) people.push_back(i);
		list<int>::iterator dPoint = people.begin();
		while (people.size() > 2)
		{
			dPoint = people.erase(dPoint);
			if (dPoint == people.end()) dPoint = people.begin();

			for (int i = 0; i < K-1; i++)
			{
				dPoint++;
				if (dPoint == people.end()) dPoint = people.begin();
			}
		}
		cout << people.front() << " " << people.back() << endl;
	}
}
