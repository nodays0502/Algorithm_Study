package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2098 {
    static int n;
    static int map[][];
    static boolean visited[];
    static int dp[][];
    static int LIMIT = 1_000_001;
    static int cal(int depth, int now,int route){
        if(dp[now][route] != 0){
            return dp[now][route];
        }

        visited[now] = true;
        if(depth == n-1 && map[now][0] != 0){
            visited[now] = false;
            return map[now][0];
        }

        int result = 0;
        int temp = 1_000_000_000;

        for(int i = 0 ; i < n ; i++){
            if(now != i && !visited[i] && map[now][i] != 0 ){
                int tempRoute = route | (1 << i);
                temp = Math.min(temp, cal(depth + 1, i,tempRoute) + map[now][i]);
            }
        }

        result += temp;
        visited[now] = false;
        dp[now][route] = result;

        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n];
        dp = new int[n][1 << n + 1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        System.out.println(cal(0,0, 0));
    }
}
