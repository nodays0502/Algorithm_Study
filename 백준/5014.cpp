#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

int cache[1000001];

int main()
{
	int maxFloor;
	int nowFloor;
	int goal;
	int up;
	int down;
	cin >> maxFloor >> nowFloor >> goal>> up >> down;
	queue<int> WFS;
	WFS.push(nowFloor);
	cache[nowFloor] =1;
	int tempFloor;
	while (!WFS.empty())
	{
		tempFloor = WFS.front();
		WFS.pop();
		if (tempFloor == goal)
		{
			cout << cache[tempFloor] - 1;
			return 0;
		}
		else
		{
			int nextFloor[2] = { tempFloor + up, tempFloor - down };
			for (int i = 0; i < 2; i++)
			{
				if (1 <= nextFloor[i] && nextFloor[i] <= maxFloor && cache[nextFloor[i]] == 0)
				{
					cache[nextFloor[i]] = cache[tempFloor] + 1;
					WFS.push(nextFloor[i]);
				}
			}
		}
	}
	cout << "use the stairs";
	
}
