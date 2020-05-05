#include <string>
#include <vector>
#include<algorithm>
#include<cstring>

using namespace std;
int cache[1000000];
vector<int> Gmoney;

int cal(int n,bool first)
{
    if(first == false && Gmoney.size() <= n) return 0;
    if(first == true && Gmoney.size()-1 <= n) return 0;
    int& result = cache[n];
    if(result != -1) return result;
    result = max(cal(n+1,first),cal(n+2,first)+Gmoney[n]);
    return result;
}

int solution(vector<int> money) {
    int answer = 0;
    for(int i =0;i<money.size();i++)
    {
        cache[i] = -1;
    }
    Gmoney = money;
    answer = cal(2,true)+money[0];
    for(int i =0;i<money.size();i++)
    {
        cache[i] = -1;
    }
    answer = max(answer,cal(1,false));
    return answer;
}
