package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2407 {
    static BigInteger dp[][];
    static BigInteger cal(int n , int m){
        if(dp[n][m] != null){
            return dp[n][m];
        }else{
            if(m == 0 || n == m) {
                return BigInteger.valueOf(1);
            }else{
                dp[n][m] = cal(n-1,m-1).add(cal(n-1,m));
                return dp[n][m];
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        dp = new BigInteger[101][101];
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        System.out.println(cal(n,m));
    }
}
