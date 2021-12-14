package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1309 {
    static int dp[][];
    static int n;
    static final int LIMIT = 9901;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+5][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for(int i = 2 ;i <= n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % LIMIT;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % LIMIT;
            dp[i][2] = (dp[i-1][0] + dp[i-1][2]) % LIMIT;
        }
        int result = (dp[n][0] + dp[n][1] + dp[n][2]) % LIMIT;
        System.out.println(result);
    }
}
