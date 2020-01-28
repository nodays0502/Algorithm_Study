#include<iostream>
using namespace std;
int temp[300001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	int num;
	int index = -1;
	cin >> num;
	int answer = num -1;
	int i;
	for (i = 0; i < num; i++)
	{
		cin >> temp[i];
		if (index == -1 && temp[i] == num) index = i;
	}
	index--;
	num--;
	for (i = index; i >= 0; i--)
	{
		if (temp[i] == num) { answer--; num--; }
	}
	cout << answer << endl;
}
