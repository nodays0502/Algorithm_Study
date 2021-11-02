package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1309 {
    static int dp[][];
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[3][n];
        Arrays.fill(dp,1);
        for(int i = 0 ;i < n; i++){
            dp[0][i] = dp[0][i-1] + dp[1][i-1] + dp[2][i-1];
        }
    }
}
