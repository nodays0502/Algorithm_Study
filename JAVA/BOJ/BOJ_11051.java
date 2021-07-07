package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
    static int dp[][];
    static int cal(int n, int k){
        if(dp[n][k] != 0) return dp[n][k];
        if(n == k )return 1;
        else if(k == 0) return 1;
        else{
            return dp[n][k] = (cal(n-1,k) + cal(n-1,k-1)) % 10007;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n  = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());
        dp = new int[n+1][k+1];
        System.out.println(cal(n,k));

    }
}
