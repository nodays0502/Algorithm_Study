#include <string>
#include <vector>
#include <map>
#include<iostream>
using namespace std;
int checkBox[100001];
bool checking(const int& vSize)
{
    for(int i =1;i<=vSize;i++)
        if(checkBox[i] == 0) return false;
    return true;
}
vector<int> solution(vector<string> gems) {
    vector<int> answer;
    map<string,int>temp;
    int count=1;
    for(auto i: gems)
    {
        if(!temp[i])
        {

            temp[i] = count;
            cout<<i<<" "<<temp[i]<<endl;
            count++;
        }
    }
    int rp=0,lp=0;
    int results=0,resulte=1000000;
    while(lp <gems.size())
    {
        checkBox[temp[gems[lp]]]++;
        if(checking(temp.size()))
        {
        if(resulte-results > lp-rp){results = rp+1; resulte = lp+1;}
        while(1)
        {
            bool ok = false;
            if(checkBox[temp[gems[rp]]]>=2){
                checkBox[temp[gems[rp]]]--;
                         ok=true;
            }
            else
            {
                if(resulte-results > lp-rp){results = rp+1; resulte = lp+1;}
                break;
            }        
            rp++;
        }}
        lp++;
    }
    answer.push_back(results);
    answer.push_back(resulte);
    return answer;
}
