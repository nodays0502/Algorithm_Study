#include <iostream>
#include <vector>
#include<algorithm>
using namespace std;
int solution(vector<int> sticker);
int include1[100001];
int include2[100001];
int main()
{
    vector<int>sticker = { 1, 3, 2, 5, 4 };
    cout << "답:" << solution(sticker) << endl;
}


int solution(vector<int> sticker)
{
    int answer = 0;
    if (sticker.size() == 1)
        return sticker[0];

    include1[0] = sticker[0];
    include1[1] = sticker[0];
    include2[0] = 0;
    include2[1] = sticker[1];
    for (int i = 2; i < sticker.size()-1; i++)
    {
        include1[i] = max(include1[i-2] + sticker[i],include1[i-1]);
    }
    for (int i = 2; i < sticker.size(); i++)
    {
        include2[i] = max(include2[i - 2] + sticker[i], include2[i - 1]);
    }
    answer = max(include1[sticker.size() - 2], include2[sticker.size()-1]);
    return answer;
}
