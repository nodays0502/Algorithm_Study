package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14501 {

    static int n;
    static int dp[];
    static int input[];
    static int money[];

    static int dfs(int now) {
        if (now >= n) {
            return 0;
        }
        if (dp[now] != -1) {
            return dp[now];
        }
        int result = 0;
        if(now + input[now] <= n){
            for(int i = now+input[now]; i < n ; i++){
                result = Math.max(dfs(i),result);
            }
            result += money[now];
        }for(int i = 1 ; i < input[now] ; i++){
            result = Math.max(dfs(now+1),result);
        }
        dp[now] = result;
        return dp[now];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        input = new int[n];
        money = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i] = stoi.apply(st.nextToken());
            money[i] = stoi.apply(st.nextToken());
        }
        Arrays.fill(dp, -1);
        System.out.println(dfs(0));
    }
}
