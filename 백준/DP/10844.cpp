#include<iostream>
#include<string.h>
using namespace std;
int N;
long long cache[10][100];
const long long limit = 1000000000;
long long resolve(int x, int y)
{
	if (y > 9 || y < 0) return 0;
	long long& result = cache[y][x];
	if (result != -1) return result;
	result = (resolve(x - 1, y - 1) + resolve(x - 1, y + 1))%limit;
	return result;
}
int main()
{
	memset(cache, -1, sizeof(cache));
	for (int i = 1; i < 10; i++) cache[i][0] = 1;
	cache[0][0] = 0;
	cin >> N;
	long long result=0;
	for (int i = 0; i < 10; i++)
	{
		result += resolve(N - 1, i)%limit ;
		result %= limit;
	}
	cout << result << endl;
}
