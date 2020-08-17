#include<iostream>
#include<map>
using namespace std;
map<int, int>people;
bool checkdot(int x, int y)
{
	map<int, int>::iterator it = people.lower_bound(x);
	if (it == people.end()) return false;
	return y < it->second;
}
void removedot(int x, int y)
{
	map<int, int>::iterator it = people.lower_bound(x);
	if (it == people.begin()) return;
	it--;
	while (1)
	{
		if (y < it->second) break;
		if (it == people.begin())
		{
			people.erase(it); break;
		}
		else
		{
			map<int, int>::iterator jt = it;
			jt--;
			people.erase(it);
			it = jt;
		}
	}
}
int adddot(int x, int y)
{
	if(checkdot(x,y)) return people.size();
	removedot(x, y);
	people[x] = y;
	return people.size();
}
int main()
{
	int t;
	cin >> t;
	int N;
	while (t--)
	{
		int x, y;

		int result = 0;
		cin >> N;
		people.clear();
		for (int i = 0; i < N; i++)
		{
			cin >> x >> y;
			result += adddot(x, y);
		}
		cout << result << endl;
	}
}
