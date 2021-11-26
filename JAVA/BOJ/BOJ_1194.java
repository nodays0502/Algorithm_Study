package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1194 {
    static int n,m;
    static char map[][];
    static int sy, sx;
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int visited[][][] = new int[n][m][1 << 6];
        queue.offer(new int[] {sy,sx,0});
        int cnt = 0 ;
        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = queue.poll();
                int nowy = now[0];
                int nowx = now[1];
                int keys = now[2];
//                System.out.printf("%d %d %d %d \n",nowy,nowx,keys,cnt);
                if(map[nowy][nowx] == '1'){
                    return visited[nowy][nowx][keys];
                }
                for(int i = 0 ; i < 4; i++){
                    int ny = nowy + dy[i];
                    int nx = nowx + dx[i];
                    int nowkeys = keys;
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != '#'){
                        if(map[ny][nx] >= 'a' && map[ny][nx] <= 'f'){
                            nowkeys = keys | 1<< (map[ny][nx] - 'a');
                        }else if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F'){
                            int flag = nowkeys & 1 << (map[ny][nx] - 'A');
                            if(flag == 0){
                                continue;
                            }
                        }
                        if(visited[ny][nx][keys] == 0){
                            visited[ny][nx][keys] = cnt;
                            queue.offer(new int[] {ny,nx,nowkeys});
                        }
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
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
                if(map[i][j]== '0'){
                    sy = i;
                    sx = j;
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs());
    }
}
