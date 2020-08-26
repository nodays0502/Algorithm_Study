#include <string>
#include <vector>
#include <deque>
#include <cmath>
#include<algorithm>
#include<iostream>
using namespace std;
char operation[3] = {'*','+','-'};
bool use[3];
long long mResult = 0;
void cal(deque<long long> num,deque<char> op)
{
    if(num.size() ==1) 
    {
        mResult = max(mResult,abs(num.front()));
        return ;
    }

    for(int i =0;i<3;i++)
    {
        if(use[i]) continue;
        use[i] = true;

        deque<long long> next ;
        deque<char> nextOp;

        deque<long long> temp = num ;
        deque<char> tempOp = op;
        

        
        while(!temp.empty() && !tempOp.empty()){
            char now = tempOp.front(); tempOp.pop_front();
            if(now == operation[i])
            {
                long long a = temp.front(); temp.pop_front();
                long long b = temp.front(); temp.pop_front();
                switch(now)
                {
                    case'*' : temp.push_front(a*b); break;
                    case'+' : temp.push_front(a+b); break;
                    case'-' : temp.push_front(a-b); break;
                }
            }
            else
            {
                nextOp.push_back(now);
                next.push_back(temp.front());temp.pop_front();
            }
        }
        while(!temp.empty())
        {
            next.push_back(temp.front()); temp.pop_front();
        }
        while(!tempOp.empty())
        {
            nextOp.push_back(tempOp.front()); tempOp.pop_front();
        }
        cal(next,nextOp);
        use[i] = false;
    }
    return ;
}
long long solution(string expression) {
    long long answer = 0;
    deque<long long> temp;
    deque<char> tempOp;
    int now=0;
    string num = "";
    while(now < expression.size())
    {
        if(expression[now] >='0' && expression[now]<='9')
        {
            num += expression[now];
        }
        else
        {   
            temp.push_back((long long)stoi(num));
            tempOp.push_back(expression[now]);
            num = "";
        }
        now++;
    }
    temp.push_back((long long)stoi(num));
    cal(temp,tempOp);
    answer = mResult;
    return answer;
}
