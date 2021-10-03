import java.util.*;
class Solution {
    class Node{
        int y , x, money, dir;
        public Node(int y , int x , int money,int dir){
            this.y = y;
            this.x = x;
            this.money = money;
            this.dir = dir;
        }
    }
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    int bfs(int[][] board){
        int visited[][][] = new int[board.length][board[0].length][4];
        for(int i = 0 ; i < board.length ; i ++){
            for(int j = 0 ; j < board[0].length ; j ++){
                Arrays.fill(visited[i][j],Integer.MAX_VALUE);
            }
        }
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
            return o1.money - o2.money;
        });
        q.offer(new Node(0, 0, 0, -1));
        while(!q.isEmpty()){
            Node now = q.poll();
            int nowDir = now.dir;
            int money = now.money;
            for(int i = 0 ; i < 4 ; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length && board[ny][nx] == 0){
                    if(nowDir == -1 || nowDir == i){
                        if(visited[ny][nx][i] >= money + 100){
                            visited[ny][nx][i] = money + 100;
                            q.offer(new Node(ny,nx,money + 100,i));
                        }
                    }else {
                        if(visited[ny][nx][i] >= money + 600){
                            visited[ny][nx][i] = money + 600;
                            q.offer(new Node(ny,nx,money + 600,i));
                        }
                    }
                }
            }
        }
        // for(int i = 0 ; i < board.length ; i++){
        //     for(int  j = 0 ; j < board[0].length ; j++){
        //         System.out.print(visited[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < 4 ; i++){
            result = Math.min(visited[board.length-1][board[0].length -1][i],result);
        }
        return result;
    }
    public int solution(int[][] board) {
        int answer = 0;
        answer= bfs(board);
        return answer;
    }
}
