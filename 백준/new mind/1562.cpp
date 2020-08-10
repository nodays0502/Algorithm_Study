#include<iostream>
#include<cstring>
using namespace std;
int cache[101][10][1 << 10];
int N;
const int limit = 1000000000;
int cal(int a, int num, int c)
{
	if (a == N && c == (1 << 10) - 1) return 1;
	if (a == N && c != (1 << 10) - 1) return 0;
	int& result = cache[a][num][c];
	if (result != -1) return result;
	result = 0;
	if (num > 0) result += cal(a+1, num-1, c | (1<<num-1))%limit;
	if (num < 9) result += cal(a+1, num+1, c | (1<<num+1))%limit;
	result %= limit;
	return result;
}
int main()
{
	cin >> N;
	int result = 0;
	memset(cache, -1, sizeof(cache));
	for (int i = 1; i < 10; i++)
	{
		result += cal(1, i, 1<<i);
		result %= limit;
	}
	cout << result << endl;

}
