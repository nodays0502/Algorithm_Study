package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2468 {

    static int n;
    static int map[][];
    static boolean visited[][];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};

    static int cal(int now) {
        visited = new boolean[n][n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] > now) {
                    dfs(i, j, now);
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(int y, int x, int now) {
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && map[ny][nx] > now){
                dfs(ny,nx,now);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        int min = 100;
        int max = 0;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi.apply(st.nextToken());
                min = Math.min(map[i][j] , min);
                max = Math.max(map[i][j] , max);
            }
        }
        int result = 1;
        for(int i = min ; i < max ; i++){
            result = Math.max(cal(i),result);
//            System.out.println(result);
        }
        System.out.println(result);
    }

}
