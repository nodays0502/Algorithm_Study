#include <string>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;
int cache[500][500];
vector<vector<int>> map;
int cal(int x,int y)
{
    if(y >= map.size()) return 0;
    int& result = cache[y][x];
    if(result != -1) return result;
    result = map[y][x];
    result += max(cal(x,y+1),cal(x+1,y+1));
    return result;
}

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    map = triangle;
    memset(cache,-1,sizeof(cache));
    answer = cal(0,0);
    return answer;
}
