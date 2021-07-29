package BOJ;

import java.util.Scanner;

public class BOJ_2579 {

    static int n;
    static int input[];
    static int dp[][];

    static int dfs(int now, int count) {
        if (now < 0) {
            return 0;
        }
        if(dp[now][count] != -1){
            return dp[now][count];
        }
        int result = 0;
        if(count == 2){
            result = dfs(now-2,1);
        }else{
            result = Math.max(dfs(now-1,count+1),dfs(now-2,1));
        }
        result += input[now];
        dp[now][count] = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new int[n];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
        }
        System.out.println(dfs(n-1,1));
    }
}
