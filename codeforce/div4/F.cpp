#include<iostream>
#include<string>
using namespace std;
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		string temp = "";
		int n0, n1, n2;
		cin >> n0 >> n1 >> n2;
		int count = n0;
		int nowtemp = -1;
		if (count >= 1)
		{
			temp += "00";
			count--;
			while (count)
			{
				temp += "0";
				count--;
			}
		}
		if(n0) nowtemp = 0;
		count = n2;
		if (count >= 1)
		{
			temp += "11";
			count--;
			while (count)
			{
				temp += "1";
				count--;
			}
		}
		if(n2) nowtemp = 1;
		count = n1;
		if (n0 && n2){count--;}
		while (count)
		{
			if (nowtemp==1)
			{
				temp += "0";
				nowtemp = 0;
			}
			else if(nowtemp ==0)
			{
				temp += "1";
				nowtemp = 1;
			}
			else 
			{
				temp += "10";
				nowtemp = 0;
			}
			count--;
		}
		cout << temp << endl;
	}
}
