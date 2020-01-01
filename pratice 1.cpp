/*
#include<iostream>
using namespace std;

int main()
{
	int T;
	cin >> T;
	int* profit;
	profit = new int[T];
	int N;
	int* temp = NULL;
	int maxIndex;
	int i, j, k;

	for (i = 0; i < T; i++)
	{
		maxIndex = 0;
		profit[i] = 0;
		cin >> N;
		if (temp == NULL)
		{
			temp = new int[N];
		}
		else if ((sizeof(*temp) / sizeof(int)) < N)
		{
			delete[] temp;
			temp = new int[N];
		}
		for (j = 0; j < N; j++)
		{
			cin >> temp[j];
			if (temp[j] > temp[maxIndex]) maxIndex = j;
		}
		j = 0;
		while (maxIndex < N)
		{
			for (j; j < maxIndex; j++)
			{
				profit[i] += (temp[maxIndex] - temp[j]);
			}// j = maxIndex;
			j++;
			maxIndex = j;
			for (k = j; k < N; k++)
			{
				if (temp[k] > temp[maxIndex]) maxIndex = k;
			}
		}
	}
	for (i = 0; i < T; i++)
	{
		cout << "#" << i+1 << " " << profit[i]<<endl;
	}
	delete[] temp;
	delete[] profit;
}
*/
#include<iostream>
using namespace std;
#define MAX 1000000
int temp[MAX];
int main()
{
	int T;
	cin >> T;
	long long profit;
	int N;

	int maxIndex;
	int i, j;

	for (i = 0; i < T; i++)
	{
		profit = 0;
		cin >> N;

		for (j = 0; j < N; j++)
		{
			cin >> temp[j];
		} // j == N;
		j--;
		maxIndex = N - 1;
		for (j; j >= 0; j--)
		{
			if (temp[maxIndex] > temp[j]) 
				profit += (temp[maxIndex] - temp[j]);
			else
				maxIndex = j;
		}
		cout << "#" << i + 1 << " " << profit << endl;
	}
}