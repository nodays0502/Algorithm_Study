package BOJ;

import java.util.Scanner;

public class BOJ_9095 {
    static int n;
    static int dp[]= new int[12];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp[1] = 1; // 1
        dp[2] = 2; // 1 +1 , 2
        dp[3] = 4; // 1 + 1 + 1 , 1 + 2 , 2+ 1 , 3
//        dp[4] = 7;
        for(int i = 4; i < 12; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int i= 0 ; i < n ; i++){
            int now = sc.nextInt();
            System.out.println(dp[now]);
        }
    }
}
