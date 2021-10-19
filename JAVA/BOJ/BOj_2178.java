import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOj_2178 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j) - '0';
            }
        }
        System.out.println(bfs(map,n,m));;
    }

    private static int bfs(int[][] map, int n, int m){
        int dy[] = {1,0,-1,0};
        int dx[] = {0,1,0,-1};
        int result = 0;
        int visited[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[] now = q.poll();
//            System.out.println(now);
            if(now[0] == n-1 && now[1] == m-1){
                result = now[2];
                break;
            }
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                int count = now[2];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 1 &&(visited[ny][nx] == 0 || visited[ny][nx] >= count + 1 )){
                    visited[ny][nx] = count+1;
                    q.offer(new int[]{ny,nx,count+1});
                }
            }
        }
        return result;
    }
}
