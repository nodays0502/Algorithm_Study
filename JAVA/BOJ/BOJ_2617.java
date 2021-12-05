package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2617 {
    static int n,m;
    static int map[][];
    static boolean visited[][];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j) - '0';
            }
        }
        boolean flag = false;
        for(int i = 0 ; i < m ; i++){
            if(!visited[0][i] && map[0][i] == 0){
                flag = dfs(0,i);
            }
            if(flag){
                break;
            }
        }
        if(flag) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static boolean dfs(int y, int x) {
        visited[y][x] = true;
        if(y == n-1){
            return true;
        }
        for(int i = 0 ; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx]&& map[ny][nx] == 0){
                if(dfs(ny,nx)){
                    return true;
                }
            }
        }
        return false;
    }

}
