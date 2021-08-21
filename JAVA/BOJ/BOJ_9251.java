package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9251 {

    static String command[] = new String[2];
    static int dp[][];
    static int n, m;

    static void dfs(int y, int x) {
        if (y > n) {
            return;
        }
        char now1 = command[0].charAt(y-1);
        char now2 = command[1].charAt(x-1);
        dp[y][x] = Math.max(dp[y][x],dp[y-1][x]);
        dp[y][x] = Math.max(dp[y - 1][x], dp[y][x - 1]);
        if (now1 == now2) {
            dp[y][x] = Math.max(dp[y][x], dp[y - 1][x - 1] + 1);
        } else {
            dp[y][x] = Math.max(dp[y][x], dp[y - 1][x - 1]);
        }

        x++;
        if (x > m) {
            y++;
            x = 1;
        }
        dfs(y, x);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        command[0] = br.readLine();
        command[1] = br.readLine();
        n = command[0].length();
        m = command[1].length();
        dp = new int[n+1][m+1];
        dfs(1, 1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n][m]);


    }

}
