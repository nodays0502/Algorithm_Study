package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2573 {
    static int n, m;
    static int map[][];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static void cal(){
        int[][] temp = new int[n][m];
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0){
                    continue;
                }
                for(int k = 0 ; k < 4 ; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 0){
                        temp[i][j]--;
                    }
                }
            }
        }
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] += temp[i][j];
                if(map[i][j] <0){
                    map[i][j] = 0;
                }
            }
        }
    }
    static boolean check(){
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    static int calPart(){
        int result = 0;
        boolean visited[][] = new boolean[n][m];
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    result++;
                    dfs(i,j,visited);
                }
            }
        }
        return result;
    }
    static void dfs(int y, int x, boolean[][] visited){
        visited[y][x] = true;
        for(int k = 0 ; k < 4 ; k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 0 && !visited[ny][nx]){
                dfs(ny,nx,visited);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int cnt = 0;
        boolean flag = false;
        while(!check()){
            cnt++;
            cal();
            if(calPart() >= 2){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println(cnt);
        }else{
            System.out.println(0);
        }
    }
}
