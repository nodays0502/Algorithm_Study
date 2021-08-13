package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    static int n;
    static int map[][];
    static int dp[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        dp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j <= i ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(cal(0,0));
    }

    private static int cal(int y , int x) {
        if(y == n) return 0;
        if(dp[y][x] != -1) return dp[y][x];
        int result = 0;
        result = Math.max(cal(y+1,x),cal(y+1,x+1));
        result += map[y][x];
        dp[y][x] = result;
        return result;
    }
}
