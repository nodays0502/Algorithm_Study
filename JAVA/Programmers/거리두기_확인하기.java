import java.util.*;
class Node{
    int starty, startx;
    int y, x;
    public Node(int starty, int startx , int y , int x){
        this.starty = starty;
        this.startx = startx;
        this.y = y;
        this.x = x;
    }
}
class Solution {
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static char map[][];
    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0; j < 5 ; j++){
                if(map[i][j] == 'P'){
                    q.offer(new Node(i,j,i,j));
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int t = 0 ; t < size ; t++){
                Node now = q.poll();
                int starty = now.starty;
                int startx = now.startx;
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];
                    if(ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && (ny != starty || nx != startx) ){
                        if(map[ny][nx] == 'P'){
                            return 0;
                        }else if(map[ny][nx] == 'O'){
                            q.offer(new Node(starty,startx,ny,nx));   
                        }
                    }
                }
            }
            cnt++;
            if(cnt == 2) break;
        }
        return 1;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        map = new char[5][];
        int index = 0;
        for(String[] place : places){
            for(int i = 0 ; i < 5 ; i++){
                map[i] = place[i].toCharArray();
            }
            System.out.println(Arrays.deepToString(map));
            answer[index++] = bfs();
        }
        return answer;
    }
}
