#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int N, M;
int map[500][500];
int cache[500][500][5][5];
int movey[4] = {1,0,-1,0};
int movex[4] = {0,1,0,-1};
//int sCase1[4][2] = { {0,0}, {1,0} ,{1,1}, {2,0} }; // ㅏ
//int sCase1[4][2] = { {0,0}, {1,0} ,{-1,1}, {2,0} }; // ㅓ
//int sCase1[4][2] = { {0,0}, {0,1} ,{0,2}, {1,1} }; // ㅜ
//int sCase1[4][2] = { {0,0}, {0,1} ,{0,2}, {-1,1} }; // ㅗ
int sCase[4][4][2] = { { {0,0}, {1,0} ,{1,1}, {2,0} }, // ㅏ
						{ {0,0}, {1,0} ,{1,-1}, {2,0} }, // ㅓ
						{ {0,0}, {0,1} ,{0,2}, {1,1} }, // ㅜ
						{ {0,0}, {0,1} ,{0,2}, {-1,1} } // ㅗ
};
const int INF = 987654321;
int DFS(int x,int y,int count,int type) {
	if (x < 0 || x >= M || y < 0 || y >= N) return -INF;
	if (count == 0) return 0;
	int& result = cache[y][x][count][type];
	if (result != -1) return result;
	result = map[y][x];
	int temp = 0;
	for (int i = 0; i < 4; i++)
	{
		if (type == 5)
			temp = max(temp, DFS(x + movex[i], y + movey[i], count - 1, i));
		else if (i != type && i % 2 == type % 2);
		else
			temp = max(temp, DFS(x + movex[i], y + movey[i], count - 1, i));
	}
	result += temp;
	return result;
}
int find(int x,int y)
{
	int result =0;
	for (int i = 0; i < 4; i++)
	{
		int tempsum = 0;
		for (int j = 0; j < 4; j++)
		{
			int newx = x + sCase[i][j][1];
			int newy = y + sCase[i][j][0];
			if (newx >= 0 && newx < M && newy >=0 && newy < N)
				tempsum += map[newy][newx];
			else { tempsum = 0; break; }
		}
		result = max(result, tempsum);
	}
	result = max(result, DFS(x, y, 4, 5));
	return result;
}
int main()
{
	cin >> N >> M;
	memset(cache, -1, sizeof(cache));
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> map[i][j];

	int result = 0;
	for (int i = 0; i < N; i++)
	{		for (int j = 0; j < M; j++)
		{
			result = max(result, find(j, i));
		}
	}
	cout << result << endl;
}
