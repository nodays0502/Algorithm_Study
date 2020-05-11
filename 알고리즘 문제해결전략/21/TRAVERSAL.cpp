#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<int> slice(const vector<int>&first, int a, int b)
{
	return vector<int>(first.begin() + a, first.begin() + b);
}
void Tprint(const vector<int>&first,const vector<int>&second)
{
	if (first.empty()) return;
	int root = first[0];
	int N = first.size();

	int L = find(second.begin(), second.end(), root) - second.begin();
	Tprint(slice(first, 1, L+1), slice(second, 0, L));
	Tprint(slice(first, L + 1,N),slice(second,L+1,N));
	cout << root << " ";
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n;
		cin >> n;
		vector<int> first;
		vector<int> second;
		int temp;
		for (int i = 0; i < n; i++)
		{
			cin >> temp;
			first.push_back(temp);
		}
		for (int i = 0; i < n; i++)
		{
			cin >> temp;
			second.push_back(temp);
		}
		Tprint(first, second);
	}
}
