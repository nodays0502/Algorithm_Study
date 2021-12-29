import java.util.*;
class Solution {
    static void cal(int[][] map, int n){
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if( i == j || i == k || j == k || map[i][k] == 0 || map[k][j] == 0){
                        continue;
                    }
                    if(map[i][j] == 0){
                        map[i][j] = map[i][k] + map[k][j];
                    }else{
                        map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                    }
                }
            }
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] map = new int[n+1][n+1];
        for(int[] fare : fares){
            int start = fare[0];
            int end = fare[1];
            int weight = fare[2];
            map[start][end] = weight;
            map[end][start] = weight;
        }
        cal(map, n);
        int result = map[s][a] + map[s][b];
        for(int i = 1; i <= n ; i++){
            if((s != i && map[s][i] == 0) || (a != i && map[i][a] == 0) || 
              (b != i && map[i][b] == 0) ){
                continue;
            }
            result = Math.min(result , map[s][i] + map[i][a] + map[i][b]);
        }
        answer = result;
        return answer;
    }
}
