package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3109 {
    static int dy[] = {-1,0,1};
    static int dx[] = {1,1,1};
    static int n,m;
    static char map[][];
    static boolean visited[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new char[n][m];
        visited= new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int result = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(map[i][0]=='.')
            result += dfs(i,0);

        }



        System.out.println(result);
    }

    private static int dfs(int y, int x) {
        visited[y][x] = true;
        if(x == m-1) return 1;
        int result = 0 ;
        for(int i = 0 ; i < 3 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && ny < n && nx>=0 && nx < m && !visited[ny][nx] && map[ny][nx] == '.'){
                result += dfs(ny,nx);
                if(result == 1)
                    break;
            }
        }
        return result;
    }
}
