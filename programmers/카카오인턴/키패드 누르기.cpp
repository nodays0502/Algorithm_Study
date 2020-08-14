#include <string>
#include <vector>
#include<cmath>

using namespace std;
int phone[4][3] = {{1,2,3},{4,5,6},{7,8,9},{11,0,22}}; // vector<int>인 것을 보고 * #을 10 이상의 값으로 
void findSpot(int& x,int&y,const char& num){
    for(int i =0;i<4;i++)
        for(int j =0;j<3;j++)
            if(num == phone[i][j]){x =j;y=i;break;}
    return;
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int left = 11; 
    int right = 22;
    for(int i =0;i<numbers.size();i++)
    {
        if(numbers[i] == 1 | numbers[i]==4 | numbers[i]==7){answer+="L"; left = numbers[i];}
        else if(numbers[i] == 3 | numbers[i]==6 | numbers[i]==9){answer+="R"; right = numbers[i];}
        else
        {
            int targetx,targety;
            int Lx,Ly;
            int Rx,Ry;
            findSpot(targetx,targety,numbers[i]);
            findSpot(Lx,Ly,left);
            findSpot(Rx,Ry,right);
            if(abs(Lx-targetx)+abs(Ly-targety)>abs(Rx-targetx)+abs(Ry-targety))
                {answer+="R"; right = numbers[i];}
            else if(abs(Lx-targetx)+abs(Ly-targety)==abs(Rx-targetx)+abs(Ry-targety))
                {
                    if (hand == "right"){answer+="R"; right = numbers[i];}
                    else {answer+="L"; left = numbers[i];}
                }
            else{answer+="L"; left = numbers[i];}
        }
    }
    return answer;
}
