package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1987 {
    static int n,m;
    static char map[][];
    static boolean count[] = new boolean[26];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int cal(int y, int x){
        int result = 0;
        count[map[y][x]-'A'] = true;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !count[map[ny][nx]-'A'] ){
                result = Math.max(cal(ny,nx),result);
            }
        }
        count[map[y][x]-'A'] = false;
        return result + 1 ;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new char[n][m];
        for(int i = 0 ; i < n ;  i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int result = cal(0,0);
        System.out.println(result);
    }

}
