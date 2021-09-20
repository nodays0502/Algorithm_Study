import java.util.*;

class Node {

    int y1, y2;
    int x1, x2;

    public Node(int y1, int x1, int y2, int x2) {
        if (y1 > y2 || x1 > x2) {
            int temp = y1;
            y1 = y2;
            y2 = temp;
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;
    }

    public int hashCode() {
        return y1 * 100 * 100 * 100 + x1 * 100 * 100 + y2 * 100 + x2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return y1 == node.y1 && y2 == node.y2 && x1 == node.x1 && x2 == node.x2;
    }

    public String toString() {
        return "Node{" +
            "y1=" + y1 +
            ", x1=" + x1 +
            ", y2=" + y2 +
            ", x2=" + x2 +
            '}';
    }
}

class Solution {

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int rotate[] = {-1, 1};
    static int n;
    static Set<Node> set = new HashSet<>();

    static int bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 1));
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
//            System.out.println(cnt);
            for (int t = 0; t < size; t++) {
                Node now = q.poll();
//                System.out.println(now);
                if (now.y1 == n - 1 && now.x1 == n - 1) {
                    return cnt;
                }
                if (now.y2 == n - 1 && now.x2 == n - 1) {
                    return cnt;
                }
                for (int i = 0; i < 4; i++) {// 4방 탐색
                    int ny1 = now.y1 + dy[i];
                    int nx1 = now.x1 + dx[i];
                    int ny2 = now.y2 + dy[i];
                    int nx2 = now.x2 + dx[i];
                    if (Math.min(ny1, ny2) >= 0 && Math.max(ny1, ny2) < n && Math.min(nx1, nx2) >= 0
                        && Math.max(nx1, nx2) < n && check(board, ny1, nx1, ny2, nx2)) {
                        Node temp = new Node(ny1, nx1, ny2, nx2);
//                        System.out.println(set.contains(temp));
                        if (set.add(temp)) {
//                            System.out.println("temp:" + temp);
                            q.offer(temp);
                        }
                    }
                }
                // roatation
                if (now.y1 == now.y2) {
                    for (int i = 0; i < 2; i++) {
                        int ny1 = now.y1 + rotate[i];
                        int nx1 = now.x1;
                        int ny2 = now.y2 + rotate[i];
                        int nx2 = now.x2;
                        if(Math.min(ny1, ny2) >= 0 && Math.max(ny1, ny2) < n && Math.min(nx1, nx2) >= 0
                            && Math.max(nx1, nx2) < n && board[ny1][nx1] == 0 && board[ny2][nx2] == 0){
                            Node temp = new Node(now.y1, now.x1, ny1, nx1);
                            if (set.add(temp)) {
//                                System.out.println("temp:" + temp);
                                q.offer(temp);
                            }
                            temp = new Node(now.y2, now.x2, ny2, nx2);
                            if (set.add(temp)) {
//                                System.out.println("temp:" + temp);
                                q.offer(temp);
                            }
                        }

                    }
                }
                if (now.x1 == now.x2) {
                    for (int i = 0; i < 2; i++) {
                        int ny1 = now.y1;
                        int nx1 = now.x1 + rotate[i];
                        int ny2 = now.y2;
                        int nx2 = now.x2 + rotate[i];
                        if(Math.min(ny1, ny2) >= 0 && Math.max(ny1, ny2) < n && Math.min(nx1, nx2) >= 0
                            && Math.max(nx1, nx2) < n && board[ny1][nx1] == 0 &&  board[ny1][nx1] == 0 && board[ny2][nx2] == 0) {
                            Node temp = new Node(now.y1, now.x1, ny1, nx1);
                            if (set.add(temp)) {
//                                System.out.println("temp:" + temp);
                                q.offer(temp);
                            }
                            temp = new Node(now.y2, now.x2, ny2, nx2);
                            if (set.add(temp)) {
//                                System.out.println("temp:" + temp);
                                q.offer(temp);
                            }
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    static boolean check(int[][] board, int... arg) {
        for (int i = 0; i < arg.length; i += 2) {
            if (board[arg[i]][arg[i + 1]] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        answer = bfs(board);
        return answer;
    }
}
