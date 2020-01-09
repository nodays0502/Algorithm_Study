#include<iostream>
using namespace std;
int main()
{
	cin.tie(0);
	ios::sync_with_stdio(false);
	string temp;
	int num;
	cin >> num;
	char ch;
	int dir;
	int count;
	int j;
	for (int i = 0; i < num; i++)
	{
		temp = "";
		count = -1;
		dir = 0;
		cin.ignore();
		while (cin.peek() != '\n')
		{
			cin >> ch;
			if (ch == 'n')
			{
				temp += ch;
				cin.ignore(4); // north
			}
			else
			{
				temp += ch;
				cin.ignore(3); // west
			}
		}
		for (j = temp.length() - 1; j >= 0; j--)
		{
			if (temp[j] == 'n')
			{
				if (dir != 0) { dir = 2 * dir - 90; }
			}
			else
			{
				dir = 2 * dir + 90;
			}
			count++;
		}
		while (dir % 2 == 0 && count)
		{
			dir /= 2;
			count--;
		}
		if (count)
			cout << "#" << i + 1 <<" " <<dir << "/" << pow(2, count) << endl;
		else
			cout << "#" << i + 1 <<" " <<dir << endl;
	}
}
