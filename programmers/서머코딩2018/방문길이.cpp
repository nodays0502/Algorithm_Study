#include <string>
#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;
int solution(string dirs);
int main()
{
	string a = "ULURRDLLU";
	string b = "LULLLLLLU";
	cout << solution(a) << endl;
	cout<< solution(b) << endl;

}
int solution(string dirs) {
	int answer = 0;
	vector<pair<int, int>> trace;
	int x=0, y=0;
	pair<int, int> now;
	bool go = true;
	trace.push_back({ x,y });
	for (int i = 0; i < dirs.length(); i++)
	{
		go = true;
		if (dirs[i] == 'U') {
			if (y == 5) { go = false; }
			else
				now = { x, ++y };
		}
		else if (dirs[i] == 'D') {
			if (y == -5) { go = false; }
			else
				now = { x, --y };
		}
		else if (dirs[i] == 'R') {
			if (x == 5) { go = false; }
			else
				now = { ++x, y };
		}
		else {
			if (x == -5) { go = false; }
			else
				now = { --x, y };
		}
		if (go)
		{
			for (int j = 0; j < trace.size(); j++)
			{
				if (now == trace[j])
				{
					if (j > 0 && trace[j - 1] == trace[trace.size() - 1]) { answer--; break; }
					else if (j < trace.size() - 1 && trace[j + 1] == trace[trace.size() -1]) { answer--; break; }
				}
			}
			answer++;
			trace.push_back(now);
		}
	}
	return answer;
}
