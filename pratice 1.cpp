#include<iostream>
using namespace std;

int main()
{
	int  kg;
	int count = 0;
	cin >> kg;
	while (kg > 0)
	{
		if (kg % 5 == 0)
		{
			count += (kg / 5);
			kg %= 5;
		}
		else if (kg >= 3)
		{
			kg -= 3;
			count++;
		}
		else
		{
			count = -1;
			break;
		}
	}
	cout << count;
}