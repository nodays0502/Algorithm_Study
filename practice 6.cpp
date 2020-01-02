#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main()
{
	int n, k;
	cin >> n >> k;
	int temp;
	vector<int> quest;
	long long sum=0;

	for (int i = 0; i < n; i++)
	{
		cin >> temp;
		quest.push_back(temp);
	}
	sort(quest.begin(), quest.end(), less<int>());
	int count = 0;
	for (int i = 1; i < n ; i++)
	{
		if (i <= k) 
			count++;
		sum += (long long)count * quest[i];
	}
	cout << sum << endl;
}