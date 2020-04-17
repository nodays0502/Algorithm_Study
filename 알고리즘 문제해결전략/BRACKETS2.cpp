#include<iostream>
#include<stack>
using namespace std;
string open = "({[";
string close = ")}]";
int main()
{


	int C;
	cin >> C;
	string temp;

	while (C--)
	{
		bool matching = true;
		cin >> temp;
		stack<char> letter;
		for (int i = 0; i < temp.size(); i++)
		{
			if (open.find(temp[i]) != -1)
				letter.push(temp[i]);
			else
			{
				if (letter.empty()) { matching = false; continue; }
				if (open.find(letter.top()) != close.find(temp[i])) matching = false;
				letter.pop();
			}
		}
		if (matching && letter.empty()) cout << "YES\n";
		else cout << "NO\n";
	}
	return 0;
}
