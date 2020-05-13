#include<iostream>
#include<queue>
using namespace std;
int A=1983;
void next(int a,int b)
{
	A = (A * (long long)a + b) % 20090711;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int result = 0;
		int n, a, b;
		A = 1983;
		priority_queue<int, vector<int>, less<int>> MaxHeap;
		priority_queue<int, vector<int>, greater<int>> MinHeap;
		cin >> n >> a >> b;
		for (int i = 0; i < n;i++)
		{
			if (i != 0) next(a, b);
			if (MaxHeap.size() == MinHeap.size())
				MaxHeap.push(A);
			else
				MinHeap.push(A);
			if (!MinHeap.empty() && MinHeap.top() < MaxHeap.top())
			{
				int temp1 = MinHeap.top();
				int temp2 = MaxHeap.top();
				MinHeap.pop();
				MaxHeap.pop();
				MinHeap.push(temp2);
				MaxHeap.push(temp1);
			}
			result = (result + MaxHeap.top()) % 20090711;
		}
		cout <<result << endl;
	}
}
