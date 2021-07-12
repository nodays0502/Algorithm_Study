package BOJ;

import java.util.Scanner;

public class BOJ_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+3];
        dp[1] = 1;
        dp[2] = 2;
        final int LIMIT = 10007;
        for(int i = 3; i <=  n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % LIMIT;
        }
        System.out.println(dp[n]);
    }
}
