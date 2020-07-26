#include<iostream>
using namespace std;
double cache[2002][1001];
int n, m;
double cal(int a, int b)
{
	if (b == m) return a >= n ? 1 : 0;
	double& result = cache[a][b];
	if (result != -1.0) return result;
	result = 0.75*cal(a+2, b+1) + 0.25*cal(a+1, b+1);
	return result;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		cin >> n >> m;
		for (int i = 0; i < 2002; i++)
			for (int j = 0; j < 1001; j++)
				cache[i][j] = -1.0;
		printf("%.11lf\n", cal(0, 0));
	}
}
