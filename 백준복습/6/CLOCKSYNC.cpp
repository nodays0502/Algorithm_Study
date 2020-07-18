#include<iostream>
#include<algorithm>
using namespace std;
int clocks[16];
int moving[10][16] = {
	{4,0,1,2},
	{5,3,7,9,11},
	{5,4,10,14,15},
	{6,0,4,5,6,7},
	{6,6,7,8,10,12},
	{5,0,2,14,15},
	{4,3,14,15},
	{6,4,5,7,14,15},
	{6,1,2,3,4,5},
	{6,3,4,5,9,13}
};
bool checking()
{
	bool ok = true;
	for (int i = 0; i < 16; i++)
	{
		if (clocks[i] != 12) { ok = false; break; }
	}
	return ok;
}
const int INF = 987654321;
int cal(int button)
{
	int result = INF;
	if (button == 10) {
		if (checking()) return 0;
		else return INF;
	}
	for (int i = 0; i < 4; i++)
	{
		result = min(result, i+cal(button+1));
		for (int j = 1; j < moving[button][0]; j++)
		{
			clocks[moving[button][j]] += 3;
			if (clocks[moving[button][j]] == 15)
				clocks[moving[button][j]] = 3;
		}
	}
	return result;
}

int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		for (int i = 0; i < 16; i++)
			cin >> clocks[i];
		int result = cal(0);
		if (result == INF) cout << -1 << endl;
		else cout << result << endl;
	}
}
