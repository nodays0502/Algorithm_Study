#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;
vector<string> solution(int n, vector<int> arr1, vector<int> arr2);
int main()
{
    int num;
    cin >> num;
    int temp;
    vector<int> map1;
    vector<int> map2;
    vector<string> sol;
    for (int i = 0; i < num; i++)
    {
        cin >> temp;
        map1.push_back(temp);
    }
    for (int i = 0; i < num; i++)
    {
        cin >> temp;
        map2.push_back(temp);
    }
    sol = solution(num, map1, map2);
    for (int i = 0; i < num; i++)
    {
        cout << sol[i] << endl;
    }
    
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    string temp = "";
    for (int j = 0; j < n;j++)
    {
        temp = "";
       for (int i = 0; i < n; i++)
       {
          if ((arr1[j] % (int)(pow(2, n - i))) / (int)pow(2, n - i - 1) == 0 && (arr2[j] % (int)(pow(2, n - i))) / (int)pow(2, n - i - 1) == 0) // auto-casting
          {
             temp.push_back(' ');
          }
          else
          {
             temp.push_back('#');
          }
       }
       answer.push_back(temp);
    }
    return answer;
}
