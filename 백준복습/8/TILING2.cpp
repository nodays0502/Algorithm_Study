#include<iostream>
#include<cstring>
using namespace std;
const int limit = 1000000007;
int cache[101];
int cal(int temp)
{
	int& result = cache[temp];
	if (result != -1) return result;
	result = (cal(temp - 1) + cal(temp - 2))%limit;
	return result;
}
int main()
{
	int t;
	cin >> t;
	memset(cache, -1, sizeof(cache));
	int temp;
	while (t--)
	{
		cache[1] = 1;
		cache[2] = 2;
		cin >> temp;
		cout<<cal(temp)<<"\n";

	}
}
