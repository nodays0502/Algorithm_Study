#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class medal {
	int gold;
	int silver;
	int bronze;
public:
	int name;
	void input() { cin >> name >> gold >> silver >> bronze; }
	bool operator ==(const medal& a)
	{
		return gold == a.gold && silver == a.silver && bronze == a.bronze;
	}
	friend bool compare(const medal& a, const medal& b);
};
bool compare(const medal& a, const medal& b)
{
	{
		if (a.gold == b.gold)
		{
			if (a.silver == b.silver)
			{
				return a.bronze > b.bronze;
			}
			return a.silver > b.silver;
		}
		return a.gold > b.gold;
	}
}

int main()
{
	int N;
	int K;
	int i;
	vector <medal> sol;
	cin >> N >> K;
	medal temp;
	for (i = 0; i < N; i++)
	{
		temp.input();
		sol.push_back(temp);
	}
	sort(sol.begin(), sol.end(),compare);
	for (i = 0; i < N; i++)
	{
		if (sol[i].name == K) break;
	}
	for (int j = i-1; j >= 0; j--)
	{
		if (sol[j] == sol[i]) i--;
		else break;
	}
	cout << i+1;
}