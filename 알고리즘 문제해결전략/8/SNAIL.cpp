#include<iostream>
#include<cstring>
using namespace std;
int n,m;
double cache[1001][2001];
double cal(int day, int height)
{
	if (day == n ) return height >= m ? 1:0;
	double& result = cache[day][height];
	if (result != -1.0) return result;
	result = 0.25*cal(day + 1, height + 1) + 0.75*cal(day + 1, height + 2);
	return result;
}
int main()
{
	int t;
	cin >> t;

	while (t--)
	{
		for (int i = 0; i < 1001; i++)
			for (int j = 0; j < 2001; j++)
				cache[i][j] = -1.0;
		cin >> m >> n;
		printf("%.10lf\n", cal(0, 0));
	}
}
