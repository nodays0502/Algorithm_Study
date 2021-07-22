package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int n,m;
    static int map[][];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 1) q.offer(new int[] {i,j});
            }
        }
//        System.out.println(q.size());
        while(!q.isEmpty()){
            int size = q.size();
            for(int t = 0 ; t < size; t++){
                int[] now = q.poll();
                for(int i = 0; i < 4; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 0){
                        map[ny][nx] = 1;
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
            time++;
        }
        if(check()){
            return time-1;
        }else{
            return -1;
        }
    }
    static boolean check(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

}
