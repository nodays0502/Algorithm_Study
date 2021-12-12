package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14716 {
    static int n,m;
    static int map[][];
    static boolean visited[][];
    static int dy[] = {-1,0,1,0,-1,1,1,-1};
    static int dx[] = {0,1,0,-1,1,1,-1,-1};
    static void dfs(int y, int x){
        visited[y][x] = true;
        for(int i = 0 ; i < 8 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == 1){
                dfs(ny,nx);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    result++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(result);
    }
}
