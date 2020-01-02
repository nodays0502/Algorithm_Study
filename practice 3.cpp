#include<iostream>
using namespace std;
bool classifier(int a)
{
	if (a < 3) return false;
	else if (a % 10 != 0 && (a % 10) % 3 == 0)
	{
		cout << "-";
		if (a / 10 >= 3)
			classifier(a / 10);
		return true;
	}
	else 
		classifier(a / 10);
}
int main()
{
	int num;
	cin >> num;
	for (int i = 1; i <= num; i++)
	{
		if(!classifier(i))
			cout << i;
		cout << " ";
	}
}