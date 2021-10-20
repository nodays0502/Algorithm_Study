package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_19238 {

    static int n, m, fuel;
    static int map[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static Map<Integer, int[]> arriveNum = new HashMap<>();
    static int target = 0;
    static int ty;
    static int tx;

    static boolean bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) {
                return o1[2] - o2[2];
            }
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        q.offer(new int[]{ty, tx, 0});
        boolean visited[][] = new boolean[n][n];
        visited[ty][tx] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int time = now[2];
            if (target == 0 && map[y][x] > 0) { // 가장 근처에 있는 손님 픽업
                target = map[y][x];
                fuel -= time;
                map[y][x] = 0;
                ty = y;
                tx = x;
                return true;
            } else if (target != 0 && arriveNum.get(target)[0] == y && arriveNum.get(target)[1] == x) { // 택시에 누군가 채운 것
                target = 0;
                fuel += time;
                ty = y;
                tx = x;
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx]
                    && map[ny][nx] != 1 && time + 1 <= fuel) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx, time + 1});
                }
            }
        }
        return false;
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static Function<String, Integer> stoi = Integer::parseInt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        fuel = stoi.apply(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        ty = stoi.apply(st.nextToken()) - 1;
        tx = stoi.apply(st.nextToken()) - 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sy = stoi.apply(st.nextToken()) - 1;
            int sx = stoi.apply(st.nextToken()) - 1;
            int ey = stoi.apply(st.nextToken()) - 1;
            int ex = stoi.apply(st.nextToken()) - 1;
            map[sy][sx] = i + 2; // 그래프 표시
            arriveNum.put(i + 2, new int[]{ey, ex}); // Collection Map
        }
        boolean cnt = true;
        while (!check()) {
            cnt = bfs();
            if (!cnt) {
                break;
            }
            cnt = bfs();
            if (!cnt) {
                break;
            }
        }
        if (cnt) {
            System.out.println(fuel);
        } else {
            System.out.println(-1);
        }
    }
}
