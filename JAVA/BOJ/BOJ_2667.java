package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2667 {
    static int n;
    static int map[][];
    static boolean visited[][];
    static List<Integer> result = new ArrayList<>();
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int dfs(int y, int x){
        visited[y][x] = true;
        int result = 1;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == 1){
                result += dfs(ny,nx);
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0 ; i < n ; i++){
            String comm = br.readLine();
            for(int j = 0 ; j < n ; j++){
                map[i][j] =  comm.charAt(j) - '0';
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    result.add(dfs(i,j));
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i = 0 ; i < result.size() ; i++){
            System.out.println(result.get(i));
        }
    }
}
