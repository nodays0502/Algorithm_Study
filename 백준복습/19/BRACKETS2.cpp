#include<iostream>
#include<vector>
using namespace std;
char open[] = { '(','{','[' };
char close[] = { ')','}',']' };
string temp;
bool cal()
{
	vector<char> check;
	for (int i = 0; i < temp.size(); i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if (open[j] == temp[i]) { check.push_back(temp[i]); }
			else if (close[j] == temp[i]) 
			{
				if (check.empty()) return false;
				if (open[j] != check.back()) { return false; }
				else { check.pop_back(); }
			}
		}
	}
	if (!check.empty()) return false;
	return true;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		cin >> temp;
		if (cal())
			printf("YES\n");
		else
			printf("NO\n");
	}
}
