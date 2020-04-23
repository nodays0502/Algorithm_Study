#include<iostream>
#include<algorithm>
using namespace std;
int num[1000001];
int resolve(int t)
{
	if (t == 1) return 0;
	int& res = num[t];
	if (res != 0) return res;
	res = 987654321;
	if (t % 3 == 0) res = min(res, resolve(t / 3) + 1);
	if (t % 2 == 0) res = min(res, resolve(t / 2)+1);
	res = min(res, resolve(t - 1)+1);
	return res;
}
int main()
{
	int t;
	cin >> t;
	cout << resolve(t) << endl;
}
