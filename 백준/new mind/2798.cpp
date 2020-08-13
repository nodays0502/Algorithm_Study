#include<iostream>
using namespace std;
int num[101];
int main()
{
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		cin >> num[i];
	}
	int result = 0;
	for(int i =0;i<N;i++)
		for(int j=i+1;j<N;j++)
			for (int k = j + 1; k < N; k++)
			{
				int temp = num[i] + num[j] + num[k];
				if (temp > result&& temp <= M) result = temp;
			}
	cout << result << endl;
}
