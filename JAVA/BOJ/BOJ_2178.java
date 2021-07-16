package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int n, m;
    static int map[][];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        boolean visited[][] = new boolean[n][m];
        visited[0][0] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int t = 0 ; t < size ; t++){
                int[] now = q.poll();
                int y = now[0];
                int x = now[1];
                if(y == n-1 && x == m-1) return cnt;
                for(int i = 0 ; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(nx >= 0 && nx < m && ny >=0 && ny < n && !visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String commands = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = commands.charAt(j)-'0';
            }
        }
        System.out.println(bfs());
    }
}
