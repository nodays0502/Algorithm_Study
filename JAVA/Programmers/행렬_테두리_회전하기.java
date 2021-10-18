class Solution {
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int map[][];
    static int move(int y1, int x1, int y2, int x2){
        int result = Integer.MAX_VALUE;
        int num = map[y1][x1];
        int ny = y1;
        int nx = x1;
        for(int i = 0; i < 4; i++){
            ny += dy[i];
            nx += dx[i];
            while(ny >= y1 && ny <= y2 && nx >= x1 && nx <= x2){
                int temp = map[ny][nx];
                map[ny][nx] = num;
                num = temp;
                result= Math.min(result,num);
                ny += dy[i];
                nx += dx[i];
            }
            ny -= dy[i];
            nx -= dx[i];
        }
        return result;
    }
    static void print(int n, int m){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<m ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        int num = 1;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0; j < columns ; j++){
                map[i][j] = num++;
            }
        }
        int index = 0;
        for(int[] query : queries){
            // print(rows,columns);
            answer[index++] = move(query[0]-1, query[1]-1, query[2]-1, query[3]-1);
        }
        return answer;
    }
}

/* 2
import java.util.*;
class Solution {
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int[][] map;
    static int n,m;
    static void init(){
        map = new int[n][m];
        int num = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] = ++num;
            }
        }
    }
    static int move(int y1, int x1, int y2, int x2){ // 인덱스로 접근
        // System.out.println(y1+" "+x1);
        int ny = y1;
        int nx = x1;
        int prev = map[ny][nx];
        int result = prev;
        for(int i = 0 ; i < 4 ; i++){
            while(ny+dy[i] >= y1 && ny+dy[i] <= y2 
                  && nx+dx[i] >= x1 && nx+dx[i] <= x2){
                ny += dy[i];
                nx += dx[i];
                int temp = map[ny][nx];
                map[ny][nx] = prev;
                prev = temp;
                result = Math.min(result,prev);
            }
        }
        return result;
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        n = rows;
        m = columns;
        init();
        for(int i = 0 ; i < queries.length ; i++){
            answer[i] = move(queries[i][0]-1, queries[i][1]-1, 
                             queries[i][2]-1, queries[i][3]-1);
        }
        return answer;
    }
}

*/
