#include <string>
#include <vector>
#include<algorithm>

using namespace std;
vector<int> temp;
bool sol(int m,int k)
{
    int count = 0;
    for(int i =0;i<temp.size();i++)
    {
        if(temp[i]<m)
            count++;
        else
            count=0;
        if(count >=k)
         return true;
    }
    return false;
}
int solution(vector<int> stones, int k) {
    temp = stones;
    int result;
    int end = 200000000;
    int start = 1;
    while(start <= end)
    {
        int mid = (start+end)/2;
        if (sol(mid,k))
            end = mid -1;
        else 
            start = mid + 1;
    }
    return end;
}
