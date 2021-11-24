package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_12852 {
    static int n;
    static int next[];
    static int dp[];
    static int dfs(int now){
        if(now == 1){
            return 0;
        } else if(dp[now] != 0){
            return dp[now];
        } else{
            int result = Integer.MAX_VALUE;
            if(now % 3 == 0){
                int cnt = dfs(now / 3) + 1;
                if(cnt < result){
                    next[now] = now / 3;
                    result = cnt;
                }
            }
            if(now % 2 == 0){
                int cnt = dfs(now / 2) + 1;
                if(cnt < result){
                    next[now] = now / 2;
                    result = cnt;
                }
            }

            int cnt = dfs(now - 1) + 1;
            if (cnt < result) {
                next[now] = now - 1;
                result = cnt;
            }

            dp[now] = result;
            return dp[now];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        int now = n;
        dp = new int[n+1];
        next = new int[n+1];
        StringBuilder sb = new StringBuilder();
//        System.out.println(dfs(n));
        sb.append(dfs(n) + "\n");
        while(true){
            if(now == 1){
//                System.out.println(1);
                sb.append(1);
                break;
            }
//            System.out.print(now+" ");
            sb.append(now+" ");
            now = next[now];
        }
        System.out.println(sb.toString());
    }
}
