package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static int input[][];
    static int dp[][];
    static int n;
    static int dfs(int y, int x){
        if(y >= n) return 0;
        if(dp[y][x] != -1) return dp[y][x];
        int result = Integer.MAX_VALUE;
        result = Math.min(dfs(y+1,(x + 2) % 3),dfs(y+1,(x+1) % 3));
        result += input[y][x];
        dp[y][x] = result;
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        input = new int[n][3];
        dp = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 3; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3; i++){
            result = Math.min(result,dfs(0, i));
        }
        System.out.println(result);
    }
}
