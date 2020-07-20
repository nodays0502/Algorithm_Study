#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
string wird;
string camp;
int cache[101][101];
bool cal(int w, int s)
{
	int& result = cache[w][s];
	if (result != -1) return result;
	while (w < wird.size() && s < camp.size() && (wird[w] == camp[s] || wird[w] == '?'))
		w++, s++;
	if (w == wird.size()) return result = (s == camp.size());
	if (wird[w] == '*')
	{
		for (int i = 0; i+s <= camp.size(); i++)
		{
			if (cal(w + 1, s + i))
				return result = 1;
		}
	}
	return result = 0;
}
int main()
{
	string temp[51];
	int t;
	cin >> t;
	while (t--)
	{
		cin >> wird;
		int count;
		cin >> count;
		for (int i = 0; i < count; i++)
			cin >> temp[i];
		sort(&temp[0],&temp[count]);
		for (int i = 0; i < count; i++)
		{
			memset(cache, -1, sizeof(cache));
			camp = temp[i];
			if (cal(0, 0))
				cout << temp[i] << endl;
		}
	}
}
