#include<iostream>
using namespace std;

int main()
{
	int num; // 횟수
	int n;
	long long s; // n(문장) , s(시간)
	long long temp;
	int skipIndex;
	long long skipValue;
	long long sum;
	cin >> num;
	for (int i = 0; i < num; i++)
	{
		skipIndex = 0;
		sum = 0;
		cin >> n >> s;
		cin >> skipValue;
		for (int j = 1; j < n; j++)
		{
			cin >> temp;
			if (temp > skipValue)
			{
				s -= skipValue;
				if (s >= 0)
				{
					skipIndex = j;
					skipValue = temp;
				}
			}
			else
			{
				s -= temp;
			}
		}
		s -= skipValue;
		if (s >= 0)
		{
			cout << "0" << endl;
		}
		else if (s <= 0)
		{
			cout << skipIndex + 1 << endl;
		}
	}
}