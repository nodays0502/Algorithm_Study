#include<iostream>
using namespace std;

class Qtree
{
	bool first;
public:
	Qtree() { first = false; }
	Qtree(bool first) { this->first = first; }
	~Qtree() { ; }
	char map[4];
	Qtree* X[4];
	void input()
	{
		if (first == true) { cin >> map[0]; 					
		X[0] = new Qtree;
		X[0]->input();
		}
		else {
			for (int i = 0; i < 4; i++)
			{
				cin >> map[i];
				if (map[i] == 'x')
				{
					X[i] = new Qtree;
					X[i]->input();
				}
			}
		}
	}
	void display()
	{
		if (first == true) { change(map[0],0); }
		else {
			change(map[2],2);
			change(map[3],3);
			change(map[0],0);
			change(map[1],1);
		}
	}
	void change(char temp,int i)
	{
		cout << temp;
		if (temp == 'x') X[i]->display();
	}
};

int main()
{
	ios::sync_with_stdio(false);
	int t;
	char temp;
	cin >> t;
	while (t--)
	{

		Qtree result(true);
		cin.ignore(10,'\n');
		temp = cin.peek();
		if (temp == 'x')
		{
			result.input();
			result.display();
		}
		else
		{
			cin >> temp;
			cout << temp;
		}
		cout << endl;
	}
}
