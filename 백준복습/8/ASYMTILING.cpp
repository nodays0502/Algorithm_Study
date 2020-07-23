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
int cal2(int temp)
{
	if (temp % 2 == 0)
	{
		int result = cal(temp);
		result = (result - cal(temp / 2) + limit) % limit;
		result = (result - cal(temp / 2 - 1) + limit) % limit;
		return result;
	}
	else
	{
		return (cal(temp) - cal(temp / 2)+limit)%limit;
	}

}
int main()
{
	int t;
	cin >> t;
	memset(cache, -1, sizeof(cache));
	cache[0] = 1;
	cache[1] = 1;
	cache[2] = 2;
	int temp;

	while (t--)
	{
		cin >> temp;
		cout << cal2(temp) << endl;
	}
}
