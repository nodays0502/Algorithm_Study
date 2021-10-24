package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_9655 {
    static boolean dp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        for(int i = 4 ; i <= n ; i++){
            if(!dp[i-1] || !dp[i-3]){
                dp[i] = true;
            }
        }
        if(dp[n]){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
