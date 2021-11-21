package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1495 {
    static int n,s,m;
    static int input[];
    static int dp[][];
    static int dfs(int depth, int volume){
        if(depth == n){
            return volume;
        }else{

            if(dp[depth][volume] != -2){
                return dp[depth][volume];
            }
            int result = -1;
            int nowVolume = volume + input[depth];
            if(nowVolume <= m){
                result = Math.max(result,dfs(depth + 1, nowVolume));
            }
            nowVolume = volume - input[depth];
            if(nowVolume >= 0){
                result = Math.max(result,dfs(depth + 1, nowVolume));
            }

            dp[depth][volume] = result;
            return result;

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;

        n = stoi.apply(st.nextToken());
        s = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());

        input = new int[n];
        dp = new int[n][m+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            input[i] = stoi.apply(st.nextToken());
            Arrays.fill(dp[i],-2);
        }
        System.out.println(dfs(0,s));
    }
}
