#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int cache[101][100010];
int solution(int K, vector<vector<int>> travel) {
    int answer = 0;
    cache[0][travel[0][0]] = travel[0][1];
    cache[0][travel[0][2]] = travel[0][3];
    for(int i =1;i< travel.size();i++)
    {
        for(int j =0;j<=K;j++)
        {
            if(cache[i-1][j] == 0) continue;
            if(travel[i][0]+j <= K){
                cache[i][j+travel[i][0]] = max(cache[i][j+travel[i][0]],cache[i-1][j]+travel[i][1]);
                answer = max(answer,cache[i][j+travel[i][0]]);
            }
            if(travel[i][2]+j <= K)
            {
                cache[i][j+travel[i][2]] = max(cache[i][j+travel[i][2]],cache[i-1][j]+travel[i][3]);
                answer = max(answer,cache[i][j+travel[i][2]]);
            }
        }
    }
    return answer;
}
