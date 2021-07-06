package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048 {
    static int n,m;
    static int map[][];
    static int dp[][];
    static int dy[] = {0,1,1};
    static int dx[] = {1,0,1};
    static int dfs(int y , int x){
        if(dp[y][x] != -1) return dp[y][x];
        int result = 0;
        for(int i = 0 ; i < 3; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny>=0 && ny < n && nx >= 0 && nx < m){
                result = Math.max(result,dfs(ny,nx));
            }
        }
        result += map[y][x];
        dp[y][x] = result;
        return result;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
    }
}
