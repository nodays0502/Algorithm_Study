/*#include<iostream>
using namespace std;
void sort(int* a, int num);
int main()
{
	int num;
	int result;
	cin >> num;
	int* numbox = new int[num];
	for (int i = 0; i < num; i++)
	{
		cin >> numbox[i];
	}
	sort(numbox, num);
	if (num % 2 != 0)
	{
		result = numbox[(num) / 2] * numbox[(num) / 2];
	}
	else
	{
		result = numbox[0] * numbox[num - 1];
	}
	cout << result;
}
void sort(int* a, int num)
{
	int max;
	int temp;
	for (int j = 0; j < num - 1; j++)
	{
		max = j;
		for (int i = j+1; i < num; i++)
		{
			if (a[max] < a[i]) { max = i; }
		}
		temp = a[max];
		a[max] = a[j];
		a[j] = temp;
	}
}*/
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main()
{
	int num;
	int input;
	cin >> num;
	vector<int> numbox;
	for (int i = 0; i < num; i++)
	{
		cin >> input;
		numbox.push_back(input);
	}
	sort(numbox.begin(),numbox.end());
	int result = numbox[0]*numbox[num-1];
	cout << result;
}
