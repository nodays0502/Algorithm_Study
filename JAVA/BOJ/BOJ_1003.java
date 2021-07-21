package BOJ;

import java.util.Scanner;

public class BOJ_1003 {
    static int dp[][] = new int[41][2];
    static int n;
    static int cal(int now,int num) {
        if(now == num) return 1;
        if(now < num) return 0;
        if(dp[now][num] != -1) return dp[now][num];
        int result = 0;
        result = cal(now-1,num) + cal(now-2 , num);
        dp[now][num] = result;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i <= 40 ; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++) {
            int a = sc.nextInt();
            System.out.println(cal(a,0)+" "+cal(a,1));
        }
    }
}
