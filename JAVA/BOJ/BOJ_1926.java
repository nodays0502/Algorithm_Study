import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1926 {
    static int n,m;
    static int map[][];
    static boolean visited[][];
    static int result = 0;
    static int dy[] = {1,0,-1,0};
    static int dx[] = {0,-1,0,1};
    static int check(int y, int x){
        visited[y][x] = true;
        int count = 1;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && map[ny][nx] == 1)
                count += check(ny,nx);
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    max = Math.max(max,check(i,j));
                    result++;
                }
            }
        }
        System.out.println(result);
        System.out.println(max);
    }
}
