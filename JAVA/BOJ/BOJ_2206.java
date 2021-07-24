package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static int n, m;
    static int map[][];
    static int dy[] = {0, 1, 0, -1};
    static int dx[] = {1, 0, -1, 0};

    static int bfs() {
        int visited[][][] = new int[n][m][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, map[0][0]});
        visited[0][0][map[0][0]] = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int check = now[2];
            int count = visited[now[0]][now[1]][check];
//                System.out.println(now[0] +" "+now[1] + " "+now[2]+" "+count);
            if (now[0] == n - 1 && now[1] == m - 1) {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && visited[ny][nx][check] == 0) {
                    if (map[ny][nx] == 1 && check == 0) {
                        visited[ny][nx][check+1] = count + 1;
                        q.offer(new int[]{ny, nx, check + 1});
                    } else if (map[ny][nx] == 0) {
                        visited[ny][nx][check] = count + 1;
                        q.offer(new int[]{ny, nx, check});
                    }

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = command.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

}
