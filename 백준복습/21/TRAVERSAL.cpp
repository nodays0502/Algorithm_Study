#include<iostream>
#include<vector>
using namespace std;
vector<int> slice(const vector<int>& v, int a, int b)
{
	return vector<int>(v.begin() + a, v.begin() + b);
}
void cal(const vector<int>& UP,const vector<int>& MID)
{
	int i;
	if (UP.empty()) return;
	for (i = 0; i < MID.size(); i++)
		if (MID[i] == UP[0]) break;
	cal(slice(UP,1,i+1), slice(MID,0,i));
	cal(slice(UP,i+1,UP.size()), slice(MID,i+1,MID.size()));
	cout << UP[0] << " ";
} 
int main()
{
	int t;
	int num, temp;
	cin >> t;
	while (t--)
	{
		cin >> num;
		vector<int> UP;
		vector<int> MID;
		for (int i = 0; i < num; i++)
		{
			cin >> temp;
			UP.push_back(temp);
		}
		for (int i = 0; i < num; i++)
		{
			cin >> temp;
			MID.push_back(temp);
		}
		cal(UP,MID);
	}
}
