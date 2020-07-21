#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int cache[100002];
string temp;
int cal(int a,int b)
{
	string nTemp = temp.substr(a, b-a+1);
	bool progress = true;
	for (int i = 2; i < nTemp.size(); i++)
	{
		if (nTemp[i] - nTemp[i - 1] != nTemp[1] - nTemp[0])
		{
			progress = false;
			break;
		}
	}
	if (progress)
	{
		if (nTemp[1] - nTemp[0] == 0) return 1;
		else if (abs(nTemp[1] - nTemp[0]) == 1) return 2;
		else return 5;
	}
	bool change = true;
	for (int i = 2; i < nTemp.size(); i++)
	{
		if (i % 2 == 0)
		{
			if (nTemp[i] != nTemp[0]) { change = false; break; }
		}
		else
		{
			if (nTemp[i] != nTemp[1]) { change = false; break; }
		}
	}
	if (change) return 4;
	return 10;
}
int mem(int begin)
{
	if (begin == temp.size()) return 0;
	int& result = cache[begin];
	if (result != -1) return result;
	result = 987654321;
	for (int i = 3; i <= 5; i++)
	{
		if(begin+i<=temp.size())
			result = min(result,cal(begin, begin+i-1) + mem(begin+i));
	}
	return result;
}
int main()
{
	int t;
	cin>>t;
	while (t--)
	{
		memset(cache, -1, sizeof(cache));
		cin >> temp;
		cout << mem(0) << endl;
	}

}
