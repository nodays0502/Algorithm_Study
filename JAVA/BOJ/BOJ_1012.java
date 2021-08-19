package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1012 {
    static int n,m;
    static int k;
    static int map[][];
    static boolean visited[][];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static void dfs(int y, int x){
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >=0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 1 && !visited[ny][nx]){
                dfs(ny,nx);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int T= stoi.apply(st.nextToken());
        for(int t = 0 ; t < T ; t++){
            st = new StringTokenizer(br.readLine()," ");
            n = stoi.apply(st.nextToken());
            m = stoi.apply(st.nextToken());
            k = stoi.apply(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for(int i = 0 ; i < k ; i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                map[a][b] = 1;
            }
            int result = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
