#include<iostream>
#include<algorithm>
using namespace std;
int result[500][500];
int main()
{
	int row, col;
	cin >> row >> col;
	int sum = 0; 
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			cin >> result[i][j];
			sum += result[i][j];
		}
	}
	for (int i = row-2; i > 0; i--)
	{
		for (int j = col-2; j > 0; j--)
		{
			if (result[i][j] == 0)
			{
				result[i][j] = min(result[i + 1][j], result[i][j + 1]) - 1;
				sum += result[i][j];
			}
		}
	}
	for (int i = row - 1; i >= 0; i--)
	{
		for (int j = col - 1; j >= 0; j--)
		{
			if (j != col - 1) { if (result[i][j] >= result[i][j + 1]) { sum = -1; break; } }
			if (i != row - 1) { if (result[i][j] >= result[i + 1][j]) { sum = -1; break; } }

		}
	}
	cout << sum<<endl;
	return 0;
}
