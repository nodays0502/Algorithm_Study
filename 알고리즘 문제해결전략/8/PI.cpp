#include<iostream>
#include<cstring>
#include<string>
#include<algorithm>
#include<cmath>
using namespace std;
int cache[10005];
string now;
const int INF = 987654321;
int cal(int a,int b)
{
	string temp = now.substr(a, b-a+1);
	if (temp == string(sizeof(temp), temp[0])) return 1;
	bool progress = true;
	for (int i = 0; i < temp.size()-1; i++)
	{
		if (temp[i + 1] - temp[i] != temp[1] - temp[0]) { progress = false; break; }
	}
	if (progress && (temp[1] - temp[0] == 0)) return 1;
	if (progress && (abs(temp[1] - temp[0]) == 1)) return 2;
	if (progress) return 5;

	bool alt = true;
	for (int i = 0; i < temp.size(); i++)
	{
		if (i % 2 == 0 && temp[i] != temp[0]) { alt = false; break; }
		if (i % 2 != 0 && temp[i] != temp[1]) { alt = false; break; }
	}
	if (alt) return 4;
	return 10;
}
int mem(int begin)
{
	if (begin == now.size()) return 0;
	int& result = cache[begin];
	if (result != -1) return result;
	result = INF;
	for (int i = 3; i <= 5; i++)
	{
		if(begin +i <= now.size())
			result = min(result,cal(begin, begin+i-1)+mem(begin+i));
	}
	return result;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		string temp;
		memset(cache, -1, sizeof(cache));
		cin >> temp;
		now = temp;
		cout << mem(0) << endl;
	}
}
