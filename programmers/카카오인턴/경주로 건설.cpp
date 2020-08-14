#include <string>
#include <vector>
#include<queue>
const int INF = 987654321;
using namespace std;
int cache[26][26];
int movey[4] = {1,0,-1,0};
int movex[4] = {0,1,0,-1};
int solution(vector<vector<int>> board) {
    int answer = INF;
    struct node
    {
        int y,x, type,cost;
    };
    queue<node> q;
    if(board[0][1] != 1)
        q.push({0,1,1,100});
    if(board[1][0] != 1)
        q.push({1,0,0,100});
    int bSize = board.size();
    while(!q.empty())
    {
        node temp = q.front();
        q.pop();
        int nowx = temp.x;
        int nowy = temp.y;
        int cost = temp.cost;
        int type = temp.type;
        if(nowx == bSize-1 && nowy == bSize-1) {if(answer > cost)answer = cost;continue;}
        if(answer <= cost){continue;}
        int& result = cache[nowy][nowx];
        if(result != 0 && cost > result) continue;
        result = cost;
        for(int i =0;i<4;i++)
        {
            int newx = nowx+movex[i];
            int newy = nowy+movey[i];
            if(newx < 0 || newx >= bSize || newy < 0 || newy >= bSize) continue;
            if(board[newy][newx] == 1) continue;
            if(i == type) {q.push({newy,newx,i,cost+100});}
            else if(i%2 == type%2);
            else {q.push({newy,newx,i,cost+600});}
        }
    }
    return answer;
}
