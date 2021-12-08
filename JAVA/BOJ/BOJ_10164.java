package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10164 {
    static int n,m;
    static int dp[][];
    static int py =0,px =0;
    static int dy[] = {0,1};
    static int dx[] = {1,0};
    static int dfs(int sy, int sx ,int ey, int ex){
        if(sy == ey && sx == ex){
            return 1;
        }
        if(dp[sy][sx] != 0){
            return dp[sy][sx];
        }else{
            int result = 0;
            for(int i = 0 ; i < 2; i++){
                int ny = sy + dy[i];
                int nx = sx + dx[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    result += dfs(ny,nx,ey,ex);
                }
            }
            return result;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        dp = new int[n][m];
        int num = stoi.apply(st.nextToken());
        if(num != 0){
            py = (num - 1) / m;
            px = (num - 1) % m;
//            System.out.println(py +" "+px);
        }
//        System.out.println(dfs(0,0,py,px));
//        System.out.println(dfs(py,px,n-1,m-1));
        System.out.println(dfs(0,0,py,px) * dfs(py,px,n-1,m-1));
    }
}
