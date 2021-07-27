package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static int n,m;
    static int map[][];
    static boolean visited[][];
    static int dy[] = {1,0,-1,0,1,-1,-1,1};
    static int dx[] = {0,1,0,-1,1,1,-1,-1};
    static void bfs(int y , int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 8 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.offer(new int[] {ny,nx});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0 ) break;
            map = new int[n][m];
            visited = new boolean[n][m];
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j < m ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(map[i][j] == 1 && !visited[i][j]) {
                        bfs(i,j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
