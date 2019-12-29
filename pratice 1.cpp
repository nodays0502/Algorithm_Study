#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
/*int main()
{
	int noListenNum;
	int noLookNum;
	int count=0;
	cin >> noListenNum >> noLookNum;
	vector<string> List;
	vector<string> sol;
	string temp;
	for (int i = 0; i < noListenNum; i++)
	{
		cin >> temp;
		List.push_back(temp);
	}
	for (int i = 0; i < noLookNum; i++)
	{
		cin >> temp;
		for (int j = 0; j < noListenNum; j++)
		{
			if (temp == List[j])
			{
				sol.push_back(List[j]);
				count++;
			}
		}
	}
	cout << count<<endl;
	for (int i = 0; i < count; i++)
	{
		cout<<sol[i]<<endl;
	}
}*/
int main()
{
	vector <string> people;
	int num1, num2;
	cin >> num1 >> num2;
	string temp;
	for (int i = 0; i < num1 + num2; i++)
	{
		cin >> temp;
		people.push_back(temp);
	}
	sort(people.begin(), people.end());
	int count=0;
	vector<string> sol;
	for (int i = 0; i < num1 + num2 - 1; i++)
	{
		if (people[i] == people[i + 1])
		{
			count++;
			sol.push_back(people[i]);
		}
	}
	cout << count << endl;
	for (int i = 0; i < count; i++)
	{
		cout << sol[i] << endl;
	}
}