package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2156 {
    static int n;
    static int input[];
    static int dp[][];
    static int dfs(int index, int count){
        if(index >= n){
            return 0;
        }
        if(dp[index][count] != -1) return dp[index][count];
        int result = 0;
        if(count == 2){
            result = Math.max(dfs(index + 2,1),dfs(index + 3,1));
        }else{
            result = Math.max(dfs(index+1,count+1),dfs(index+2,1));
            result = Math.max(result,dfs(index+3,1));
        }
        result += input[index];
        dp[index][count] = result;
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        input = new int[n];
        dp = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            input[i] = stoi.apply(st.nextToken());
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
        }
        int result = Math.max(dfs(0,1),dfs(1,1));
        System.out.println(result);
    }
}
