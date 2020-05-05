#include <string>
#include <vector>
#include<algorithm>
#include<cstring>
#include<iostream>

using namespace std;
vector<int> Gleft;
vector<int> Gright;
int cache[2000][2000];
int cal(int l,int r)
{   
    if(l >=Gleft.size() || r >= Gright.size()) return 0;
    int& result = cache[l][r];
    if(result != -1) return result;
    result = 0;
    if(Gleft[l] > Gright[r])
    {
        result = max(result,cal(l,r+1)+Gright[r]);
    }
    result = max(result,cal(l+1,r+1));
    result = max(result,cal(l+1,r));
    return result;
}
int solution(vector<int> left, vector<int> right) {
    int answer = 0;
    memset(cache,-1,sizeof(cache));
 
    Gleft = left;
    Gright = right;
    
    answer = cal(0,0);
    return answer;
}
