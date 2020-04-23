#include<iostream>
#include<string.h>
using namespace std;
int cache0[41];
int cache1[41];
int fib_0(int n) {
	if (n == 1) return 0;
	if (n == 0) return 1;
	int& res = cache0[n];
	if (res != -1) return res;
	res = fib_0(n - 1) + fib_0(n - 2);
	return res;
}
int fib_1(int n)
{
	if (n == 1) return 1;
	if (n == 0) return 0;
	int& res = cache1[n];
	if (res != -1) return res;
	res = fib_1(n - 1) + fib_1(n - 2);
	return res;
}
int main()
{
	memset(cache0, -1, sizeof(cache0));
	memset(cache1, -1, sizeof(cache1));
	int t;
	cin >> t;
	while (t--)
	{
		int temp;
		cin >> temp;
		printf("%d %d\n", fib_0(temp), fib_1(temp));
	}
}
