package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_6087 {
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static char map[][];
    static int n,m;
    static boolean visited[][][];
    static int bfs(int[] start, int[] end){
        Queue<newNode> q = new PriorityQueue<>((o1,o2)->{
            return o1.cnt - o2.cnt;
        });
        q.offer(new newNode(start[0],start[1],-1,-1));
        while(!q.isEmpty()){
            newNode now = q.poll();
            System.out.println(now.y+" "+now.x+" "+ now.dir+" "+ now.cnt);
            int dir = now.dir;
            int cnt = now.cnt;
            if(now.y == end[0] && now.x == end[1]) return cnt;
            for(int i = 0 ; i < 4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != '*' && !visited[ny][nx][i]){
                    visited[ny][nx][i] = true;
                    if(dir != i){
                        q.offer(new newNode(ny,nx,cnt+1,i));
                    }else{
                        q.offer(new newNode(ny,nx,cnt,i));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        m = stoi.apply(st.nextToken());
        n = stoi.apply(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][4];
        int[] start = null;
        int[] end = null;
        for(int i = 0 ; i < n ;i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ;j++){
                map[i][j] = command.charAt(j);
                if(map[i][j] == 'C'){
                    if(start == null){
                        start = new int[]{i,j};
                    }else{
                        end = new int[]{i,j};
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(start));
//        System.out.println(Arrays.toString(end));
        System.out.println(bfs(start,end));
    }

    private static class newNode {
        int y,x,cnt,dir;

        public newNode(int y, int x, int cnt,int dir) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}
