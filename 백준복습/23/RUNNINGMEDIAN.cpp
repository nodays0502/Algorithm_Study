#include<iostream>
#include<queue>
#include<algorithm>
#include<vector>
using namespace std;
unsigned int A = 1983;
const int limit = 20090711;
void next(int a,int b)
{
	A = (A * (long long)a + b) % limit;
}
int main()
{
	int t;
	int N, a, b;
	cin >> t;
	while (t--)
	{
		cin >> N >> a >> b;
		priority_queue<int, vector<int>, less<int>> bigHalf; // 제일 작은 값
		priority_queue<int, vector<int>, greater<int>> smallHalf; // 제일 큰 값
		A = 1983;
		unsigned int result = 0;
		for (int i = 0; i < N; i++)
		{
			if (i != 0) next(a,b);
			if (bigHalf.size() == smallHalf.size())
				bigHalf.push(A);
			else smallHalf.push(A);
			if (!smallHalf.empty() && smallHalf.top() < bigHalf.top())
			{
				int c = smallHalf.top();
				int d = bigHalf.top();
				smallHalf.pop();
				bigHalf.pop();
				bigHalf.push(c);
				smallHalf.push(d);
			}
			result = (result + bigHalf.top()) % limit;
		}
		cout << result << endl;
	}
}
