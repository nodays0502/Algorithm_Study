import java.util.*;
class Solution {
    
    static int dp[][]; 
    static int dfs(int[][] land, int r, int c){
        if(r == land.length){
            return 0;
        }
        else {
            if(dp[r][c] != 0){
                return dp[r][c];
            }
            int result = 0;
            for(int i = 0; i < 4 ; i++){
                if(i == c){
                    continue;
                }
                else {
                    result = Math.max(result, dfs(land,r+1,i));
                }
            }
            result+=land[r][c];
            dp[r][c] = result;
            return result;
        }
    }
    int solution(int[][] land) {
        int answer = 0;
        dp = new int[land.length][4];
        for(int i = 0 ; i < land.length ; i++){ 
            Arrays.fill(dp[i], 0);
        } 
        for(int i = 0 ; i < 4 ; i++){
            answer = Math.max(dfs(land,0,i), answer);
        }
        return answer;
    }
}
