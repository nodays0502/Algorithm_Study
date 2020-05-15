#include<iostream>
#include<vector>
#include<algorithm>
#include<functional>
#include<queue>
 
using namespace std;
long long cache[500001];
struct Node {
	int s;
	int e;
	Node(int s, int e) { this->s = s; this->e = e; }
};
struct cmp {
	bool operator()(const Node& u, const Node& v) {
		if (u.e-u.s == v.e-v.s)
			return u.s > v.s; // v의 s가 작으면 true
		return u.e - u.s < v.e - v.s; // v의 길이가 길면 true
	}
};
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n;
		cin >> n;
		vector<int> result;
		result.resize(n + 1);
		priority_queue<Node,vector<Node>,cmp> a;
		a.push(Node(1, n));
		int count = 1;
		while (!a.empty())
		{
			int s = a.top().s;
			int e = a.top().e;
			a.pop();
			int target;
			if (s == e) { target = s; }
			else if ((s - e + 1) % 2 != 0) { target = (s + e) / 2; }
			else { target = (s + e - 1) / 2; }
			result[target] = count;
			count++;
			if(s<= target -1)
				a.push(Node(s, target - 1));
			if(target+1<=e)
				a.push(Node(target + 1, e));
		}
		for (int i = 1; i <= n; i++)
		{
			cout << result[i] << " ";
		}
	}
}
