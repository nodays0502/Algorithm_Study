package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1010 {
    static int dp[][];
    static int comb(int n , int r){
        if(dp[n][r] != 0) return dp[n][r];
        if(r == 0) return 1;
        if(n == r) return 1;
        return dp[n][r] = comb(n-1,r) + comb(n-1,r-1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int t = stoi.apply(st.nextToken());
        for(int i = 0 ; i < t ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            int max = Math.max(n,m);
            int min = Math.min(n,m);
            dp = new int[31][31];
            System.out.println(comb(max,min));
        }
    }
}
