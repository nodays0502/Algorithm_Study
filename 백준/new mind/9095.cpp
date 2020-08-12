#include<iostream>
#include<cstring>
using namespace std;
int cache[12][12]; // 자리수,합
int cal(int now,int sum,const int& num)
{
	if (sum > num) return 0;
	if (sum == num) return 1;
	int& result = cache[now][sum];
	if (result != -1) return result;
	result = 0;
	for(int i =1;i<=3;i++)
		result += cal(now + 1, sum + i, num);
	return result;
}
int main()
{
	int t;
	cin >> t;
	int num;

	while (t--)
	{
		cin >> num;
		memset(cache, -1, sizeof(cache));
		cout << cal(0,0,num) << endl;
	}
}
