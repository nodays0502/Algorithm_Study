#include<iostream>
#include<queue>
using namespace std;
int N, K;
unsigned int A ;
unsigned int next() {
	unsigned int result = A;
	A = (A * 214013u + 2531011u);
	return result % 10000 + 1;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		A = 1983;
		cin >> K >> N;
		int result = 0;
		queue<unsigned int> temp;
		unsigned int sum = 0;
		for (int i = 0; i < N; i++)
		{
			temp.push(next());
			sum += temp.back();

			while(sum > K) {sum -= temp.front();temp.pop();}
			if (sum == K) { result++; }
			
		}
		cout << result << endl;
	}
}
