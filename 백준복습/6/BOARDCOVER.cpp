#include<iostream>
using namespace std;
const int moving[4][3][2] = {
	{{0,0},{1,0},{0,1}},
	{{0,0},{0,1},{1,1}},
	{{0,0},{1,0},{1,1}},
	{{0,0},{1,0},{1,-1}}
};
int sizex, sizey;
int map[20][20];
bool set(int x, int y, int type, int delta)
{
	bool ok = true;
	for (int i = 0; i < 3; i++)
	{
		int nx = x + moving[type][i][1];
		int ny = y + moving[type][i][0];
		if (ny < 0 || ny >= sizey || nx < 0 || nx >= sizex)
			ok = false;
		else if ((map[ny][nx] += delta) > 1)
			ok = false;
	}
	return ok;
}
int cover() {
	int y = -1; 
	int x = -1;
	for (int i = 0; i < sizey; i++)
	{
		for (int j = 0; j < sizex; j++) {
			if (map[i][j] == 0) {
				y = i;
				x = j;
				break;
			}
		}
		if (y != -1) break;
	}
	if (y == -1) { return 1; }
	int result = 0;
	for(int type = 0; type < 4; type++)
	{
		if (set(x, y, type, 1))
			result += cover();
		set(x,y,type,-1);

	}
	return result;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		cin >> sizey >> sizex;
		char temp;
		for (int i = 0; i < sizey; i++)
			for (int j = 0; j < sizex; j++)
			{
				cin >> temp;
				if (temp == '#') map[i][j] = 1;
				else map[i][j] = 0;
			}

		cout << cover() << endl;
	}
}
