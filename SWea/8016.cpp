#include<iostream>
using namespace std;
void sol(long long temp);
int main()
{
	cin.tie(0);
	ios::sync_with_stdio(false);
	int num;
	cin >> num;
	long long temp;
	for (int i = 0; i < num; i++)
	{
		cin >> temp;
		cout << "#" << i + 1 << " " ;
		sol(temp);
	}
}
void sol(long long temp)
{
	long long result;
	result = 1+ 2 * (temp - 1) * (temp - 1);
	cout<<result<<" ";
	result = 1 + 2 * temp * temp - 2;
	cout<<result<<endl;
}
