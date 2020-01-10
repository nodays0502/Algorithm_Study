#include <string>
#include <vector>
#include<iostream>
using namespace std;
int solution(string skill, vector<string> skill_trees);
int main()
{
    string a = "CBD";
    vector<string>b = { "BACDE", "CBADF", "AECB","0BDA" };
    cout<<solution(a, b);
    
}

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    int preIndex;
    int nowIndex;
    int i, j, k;
    bool find;
    for (i = 0; i < skill_trees.size(); i++)
    {
        preIndex = skill_trees[i].length();
        find = false;
        for (j = skill.length() -1 ; j >= 0 ; j--)
        {
            if(find == false) k = skill_trees[i].length() - 1;
            for (k; k >= 0; k--)
            {
                if (skill_trees[i][k] == skill[j]) { nowIndex = k; find = true; break; }
            }
            if (k == -1 && find == true) { break; }
            if (k == -1 && find == false) { continue; }
            if (nowIndex < preIndex) 
            {
                preIndex = nowIndex;
            }
            else
                break ;
        }
        if (find == false || skill_trees[i][preIndex] == skill[0])
        {
            answer++;
        }
    }
    return answer;
}
