import java.util.*;
class Solution {
    static int map[][];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static void init(int row, int col){
        int num = 1;
        map = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                map[i][j] = num++;
            }
        }
    }
    static int cal(int y1, int x1, int y2, int x2){
        int ny = y1;
        int nx = x1;
        int prev = map[y1][x1];
        int result = prev;
        for(int i = 0 ; i < 4; i++){
            ny += dy[i];
            nx += dx[i];
            while(ny >= y1 && ny <= y2 && nx >= x1 && nx <= x2){
                int temp = map[ny][nx];
                map[ny][nx] = prev;
                prev = temp;
                result = Math.min(result, prev);
                ny += dy[i];
                nx += dx[i];
            }
            ny -= dy[i];
            nx -= dx[i];
        }
        // System.out.println("----------------------");
        // print();
        return result;
    }
    static void print(){
        for(int i = 0 ; i < map.length ; i++){
            for(int j = 0 ; j < map[0].length ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        init(rows,columns);
        int index = 0;
        for(int[] query : queries){
            answer[index++] = cal(query[0]-1, query[1]-1, query[2]-1, query[3]-1);
        }
        return answer;
    }
}
