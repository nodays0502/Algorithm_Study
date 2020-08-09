#include<iostream>
#include<cstring>
using namespace std;
const int limit = 1000000003;
int cache[1001][501];
int N, K;
int cal(int now, int count,bool first)
{

	if (now > N) {  return 0; }
	if (now == N && first == true) { return 0; }

	int& result = cache[now][count];
	if (result != -1) return result;

	if (count == 1) { return result = 1; }


	result = 0;


	for (int i = 2; i + now <= N; i++)
	{
		result += (cal(now + i, count - 1,first)%limit);
		result %= limit;
	}
	return result;
}
int main()
{

	cin >> N >> K;
	int result = 0;
	if (N < 2 * K) { std::cout << 0 << endl; return 0; }

	memset(cache, -1, sizeof(cache));
	for (int i = 1; i+2*K-2 <= N; i++)
	{
		if (i == 1) {
			result += cal(i, K, true);
			memset(cache, -1, sizeof(cache));
		}
		else
		{
			result += cal(i, K, false);
		}
		result %= limit;
	}
	/*for (int i = 1; i <= K; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			std::cout << cache[j][i]<<" ";
		}
		std::cout << endl;
	}*/
	std::cout << result << endl;
}
