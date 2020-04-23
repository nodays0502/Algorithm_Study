#include<iostream>
#include<algorithm>
using namespace std;


int main()
{
	int n;
	int result =-987654321;
	int sum = 0;
	int temp;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> temp;
		sum += temp;
		result = max(sum, result);
		if (sum < 0) sum = 0;
	}
	cout << result << endl;
}
