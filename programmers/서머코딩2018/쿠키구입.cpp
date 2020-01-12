#include <string>
#include <vector>
#include<iostream>

using namespace std; 
int solution(vector<int> cookie);
int main()
{
    vector<int> cookie = { 1,2,4,5 };
    cout<< solution(cookie);
}
int solution(vector<int> cookie) {
    int answer = 0;
    int tempSum;
    int tempCookie;

    for (int i = -1; i < (int)cookie.size(); i++)
    {
        for (int j = (int)cookie.size(); j > i ; j--)
        {
            tempSum = 0;
            for (int k = i + 1; k < j; k++)
            {
                tempSum += cookie[k];
            }
            if (tempSum % 2 == 0 && tempSum > 2*answer)
            {
                tempCookie = 0;
                for (int k = i + 1; k < j - 1; k++)
                {
                    tempCookie += cookie[k];
                    if (tempCookie == tempSum / 2) { answer = tempCookie; break; }
                    else if (tempCookie > tempSum / 2) { break; }
                }
            }
        }
    }
    return answer;
}
// 짝수 sum = 짝수
// 일정 구간을 더해 짝수인지 판별 아닐시 넘어간다
// 처음부터 더해 합이 sum/2인지 판별 맞으면 true
// sum/2 이 전의 값보다 작다면 구하지 않는다.
