#include<iostream>
#include<map>
using namespace std;
map<int, int>coords;
bool isD(int x, int y) // 지배당했을때 true
{
	map<int, int>::iterator it = coords.lower_bound(x);
	if (it == coords.end()) return false;
	return y < it->second;
}
void removeD(int x, int y)
{
	map<int, int>::iterator it = coords.lower_bound(x);
	if (it == coords.begin()) return;
	it--;
	while (1)
	{
		if (it->second > y) break;
		if (it == coords.begin()) {
			coords.erase(it);
			break;
		}
		else {
			map<int, int>::iterator jt = it;
			jt--;
			coords.erase(it);
			it = jt;
		}
	}
}
int reg(int x, int y)
{
	if (isD(x, y)) return coords.size();
	removeD(x, y);
	coords[x] = y;
	return coords.size();
}
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int t;
	cin >> t;
	while (t--)
	{
		int n, a, b;
		cin >> n;
		coords.clear();
		int result = 0;
		for (int i = 0; i < n; i++)
		{
			cin >> a >> b;
			result += reg(a, b);
		}
		cout << result << endl;
	}
}
