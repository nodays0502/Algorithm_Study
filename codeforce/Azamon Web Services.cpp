#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
int main()
{
	int num;
	cin >> num;
	string s, c, strTemp;
	bool answer;
	unsigned int changeIndex;
	unsigned int minSize;
	unsigned int j;
	for (int i = 0; i < num; i++)
	{
		cin >> s >> c;
		strTemp = s;
		sort(strTemp.begin(), strTemp.end());
		for (j = 0; j < s.length(); j++)
		{
			if (s[j] != strTemp[j]) { break; }
		}
		if (j < s.length())
		{
			changeIndex = s.find_last_of(strTemp[j]);
			s[changeIndex] = s[j];
			s[j] = strTemp[j];
		}
		if (s.length() < c.length()) { minSize = s.length(); answer = true; }
		else
		{
			minSize = c.length();
			answer = false;
		}
		for (j = 0; j < minSize; j++)
		{
			if (s[j] == c[j]) continue;
			else if (s[j] < c[j]) answer = true; 
			else
				answer = false;
			break;
		}
		if (answer) cout << s << endl;
		else cout << "---" << endl;
	}
}
