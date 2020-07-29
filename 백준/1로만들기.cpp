#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int cache[1000001];
const int INF = 987654321;
int cal(int a)
{
	if (a == 1) return 0;
	if (a < 1) return INF;
	int& result = cache[a];
	if (result != -1) return result;
	result = INF;
	if (a % 3 == 0)
		result = min(result, cal(a / 3) + 1);
	if (a % 2 == 0)
		result = min(result, cal(a / 2) + 1);
	result = min(result, cal(a - 1) + 1);
	return result;
}
int main()
{
	int temp;
	memset(cache, -1, sizeof(cache));
	cin >> temp;
	cout << cal(temp) << endl;
}
