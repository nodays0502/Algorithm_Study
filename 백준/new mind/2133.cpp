#include<iostream>
#include<cstring>
using namespace std;
typedef long long LL;

int cache[31];

int main()
{
	int tSize;
	cin >> tSize;
	cache[0] = 1;
	cache[2] = 3;
	//cache[4] = 11; // 3*cache[2] + 2
	if (tSize % 2 != 0) { cout << 0 << endl; return 0; }
	if (tSize >= 4)
	{
		for (int i = 4; i <= tSize; i += 2)
		{
			cache[i] = 3 * cache[i - 2];
			for (int j = 0; j <= i - 4; j += 2)
			{
				cache[i] += 2 * cache[j];
			}
		}
	}
	cout << cache[tSize] << endl;
}
