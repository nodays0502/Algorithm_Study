#include<iostream>
using namespace std;
int main()
{
	int tree[10];
	int result=0;
	int all_mux=1;
	int temp_mux;
	int temp;
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> tree[i];
		all_mux *= tree[i];
	}
	for (int i = 0; i < 4; i++)
	{
		temp_mux = all_mux;
		temp = 0;
		for (int j = 0; j < 3; j++)
		{
			int index;
			index = j - i;
			if (index < 0) index += N;
			temp_mux /= tree[index];
			temp += tree[index];
		}
		temp += temp_mux;
		if (result < temp) result = temp;
	}
	cout << result;
}
