package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2146 {
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static int map[][];
    static int n;
    static int result = 0;
    static int num = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == 1){
                    num++;
                    divide(i,j);
                }
            }
        }

        System.out.println(bfs());


    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][][] = new boolean[n][n][num + 1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] != 0){
                    for(int k = 0 ; k < 4; k++){
                        int ny = i+dy[k];
                        int nx = j+dx[k];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] == 0){
                            q.offer(new int[]{i, j, map[i][j], -1});
                            break;
                        }
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
//            System.out.println(Arrays.toString(now));
            int startNum = now[2];
            int nowy = now[0];
            int nowx = now[1];
            int count = now[3];
            if(map[nowy][nowx] != 0 && startNum != map[nowy][nowx]){
                return count ;
            }
            for(int i = 0 ; i < 4 ; i++){
                int ny = nowy + dy[i];
                int nx = nowx + dx[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx][startNum]){
                    visited[ny][nx][startNum] = true;
                    q.offer(new int[] {ny,nx,startNum,count + 1});
                }
            }
        }
        return -1;
    }

    private static void divide(int y, int x) {
        map[y][x] = num;
        for(int i = 0 ; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < n && ny >=0 && ny < n && map[ny][nx] == 1){
                divide(ny,nx);
            }
        }
    }
}
