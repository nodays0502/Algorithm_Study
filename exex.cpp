#include<iostream>
using namespace std;
void recover(string& letter, int num);

int main()
{
	cin.tie(0);
	ios::sync_with_stdio(false);
	int num;
	string letter;
	cin >> num;
	cin >> letter;
	recover(letter, num);
	cout << letter << endl;
	return 0;
}
void recover(string& letter, int num)
{
	string basic = letter;
	int backsize = letter.length() / 2;
	string temp;
	int j;

	for (j = 0; j < num; j++)
	{
		for (int i = 0; i < backsize; i++)
		{
			temp = letter[i + 1];
			letter.erase(i + 1, 1);
			letter.insert(letter.length() - i, temp);
		}
		if (basic == letter) num = j + num % (j + 1) + 1;
	}
}