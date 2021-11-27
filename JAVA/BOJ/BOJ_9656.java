package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_9656 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        boolean [] dp = new boolean[n+5];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        for(int i = 4; i <= n ; i++){
            if(!dp[i-1] && !dp[i-3]){
                dp[i] = true;
            }else{
                dp[i] = false;
            }
        }
        if(dp[n]){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
