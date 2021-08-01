package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2293 {
    static int input[];
    static int dp[][];
    static int n , k;
    static int dfs(int now, int rest){
        if(rest == 0) return 1;
        if(now == -1) return 0;
        if(dp[now][rest] != -1) return dp[now][rest];
        int result = 0;
        for(int i = 0; i <= rest / input[now] ; i++){
            result += dfs(now-1,rest - input[now] * i);
        }
        dp[now][rest] = result;
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = (s) -> Integer.parseInt(s);
        n = stoi.apply(st.nextToken());
        k = stoi.apply(st.nextToken());
        input = new int[n];
        dp = new int[n][k+1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            input[i] = stoi.apply(st.nextToken());
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(input);
        System.out.println(dfs(n-1,k));
    }
}
