#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std; 
string match;
string temp;
int cache[101][101];
bool cal(int a,int b)
{
	int& result = cache[a][b];
	if (result != -1) return result;
	while(a < match.size() && b < temp.size() && (match[a] == '?' || match[a] == temp[b]))
	{
		a++; b++;
	}
	if (a == match.size()) return result = (b == temp.size());
	if (match[a] == '*')
	{
		for (int i = 0; b + i <= temp.size(); i++)
		{
			if (cal(a + 1, b + i)) { result = 1; return result; }
		}
	}
	result = 0;
	return 0;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{

		cin >> match;
		int n;
		cin >> n;
		vector<string> card;
		string temp1;
		for (int i = 0; i < n; i++)
		{
			cin >> temp1;
			card.push_back(temp1);
		}
		sort(card.begin(), card.end());
		for (int i = 0; i < card.size(); i++)
		{
			memset(cache, -1, sizeof(cache));
			temp = card[i];
			if (cal(0, 0))
				cout << temp << endl;
		}
	}
}
