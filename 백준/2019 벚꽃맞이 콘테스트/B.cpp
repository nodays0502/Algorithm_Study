#include<iostream>
using namespace std;
int A[200000];
int mux[200000];
int fake[200000];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for (int i = 0; i < 200000; i++) mux[i] = 1;
	int N, Q;
	cin >> N >> Q;
	for (int i = 0; i < N; i++) { cin >> A[i]; }
	for (int i = 0; i < Q; i++) { cin >> fake[i]; }

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			int index = i + j;
			if (index >= N) index -= N;
			mux[i] *= A[index];
		}
	}
	int result = 0;
	for (int j = 0; j < N; j++)
	{
		result += mux[j];
	}
	for (int i = 0; i < Q; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			int index = fake[i] - j - 1;
			if (index < 0) index += N;
			mux[index] *= -1;
			result += 2 * mux[index];
		}
		cout << result << "\n";
	}
}

/*
불필요한 곱셈 계산을 없애 시간초과를 해결
*/
