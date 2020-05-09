
#include<iostream>
#include<vector>
#include<cmath>
using namespace std;
int main()
{
	int t;
	cin >> t;
	int temp;
	while (t--)
	{
		vector<int>result;
		cin >> temp;
		int count = 0;
		while (temp)
		{
			int num;
			num = temp % 10;
			num = num*(int)pow(10, count);
			if(num != 0)
				result.push_back(num);
			temp /= 10;
			count++;
		}
		cout << result.size() << endl;
		for (int i = 0; i < result.size(); i++)
			cout << result[i] << endl;
	}
}
