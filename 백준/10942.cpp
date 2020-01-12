#include<iostream>
using namespace std;



int num[2001];
int result[2001][2001];
int main()
{
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(false);
	int count;
	int S, E;
	int i;
	cin >> count;
	for (i = 1; i <= count; i++)
	{
		cin >> num[i];
	}
	int diagonal;
	for (diagonal = 0; diagonal <= count-1; diagonal++)
	{
		for (i = 1; i+diagonal <= count; i++)
		{
			if (diagonal == 0) { result[i][i] = 1; }
			else if (i + 1 < i - 1 + diagonal && result[i + 1][i + diagonal - 1] == 0)
				result[i][i + diagonal] = 0;
			else
			{
				if(num[i] == num[i+diagonal]) result[i][i + diagonal] = 1;
				else
					result[i][i + diagonal] = 0;
			}
		}
	}
	//for (i = 1; i <= count; i++)
	//{
	//	result[i][i] = 1;
	//}
	//for (i = 1; i <= count - 1; i++)
	//{
	//	if (num[i] == num[i + 1]) result[i][i + 1]=1;
	//}
	//for (diagonal = 3; diagonal <= count; diagonal++)
	//{
	//	for (i = 1; i  <= count-diagonal+1; i++)
	//	{
	//		int last = i + diagonal - 1;
	//		if (num[i] == num[last] && result[i + 1][last -1])
	//			result[i][last] = 1;
	//	}
	//}
	cin >> count;
	for (i = 0; i < count; i++)
	{
		//scanf("%d%d", &S, &E);
		//printf("%d\n", result[S][E]);
		cin >> S >> E;
		cout << result[S][E] << endl;
	}
	return 0;
}
//cin, cout이 scanf, printf에 비해서 속도가 많이 느리다고 하더군요.
//endl이 오래 걸림



