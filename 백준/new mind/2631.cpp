#include<iostream>
#include<algorithm>
using namespace std;
int num[201];
int cache[201];
int numSize;
int main()
{
	cin >> numSize;
	int Max=0;
	for (int i = 0; i < numSize; i++)
		cin >> num[i];
	for (int i = 0; i < numSize; i++)
	{
		cache[i] = 1;
		for (int j = 0; j < i; j++)
		{
			if (num[j] < num[i] && cache[i] <= cache[j])
				cache[i] = cache[i]+1;
		}
	}
	for (int i = 0; i < numSize; i++)
	{
		Max = max(Max, cache[i]);
	}
	cout << numSize - Max << endl;
}
