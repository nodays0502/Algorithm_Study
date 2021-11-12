package Codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class NO_455_A {

    static int SIZE = 100001; // 100000
    static int n;
    static int count[] = new int[SIZE];
    static long dp[] = new long[SIZE];

    static void init() {
        Arrays.fill(dp, -1);
    }

    static long dfs(int depth) {
        if (dp[depth] != -1) {
            return dp[depth];
        } else {
            long result = 0;
            for(int i = depth + 2 ; i < SIZE ; i++){
                if(count[i] > 0){
                    result = Math.max(dfs(i), result);
                    if(i +1 < SIZE && count[i+1] > 0){
                        result = Math.max(dfs(i+1), result);
                    }
                    break;
                }
            }
            result += (long)count[depth] * depth;
            dp[depth] = result;
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int temp = stoi.apply(st.nextToken());
            count[temp]++;
        }
        init();
        long result = Math.max(dfs(0),dfs(1));
        System.out.println(result);
    }
}
