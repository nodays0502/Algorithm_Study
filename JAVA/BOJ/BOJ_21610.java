package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21610 {
    static int n,m;
    static int map[][];
    static int[][] commands;
    static int dy[] = {0,-1,-1,-1,0,1,1,1};
    static int dx[] = {-1,-1,0,1,1,1,0,-1};
    static int rainDy[] = {-1,1,1,-1};
    static int rainDx[] = {1,1,-1,-1};
    static void cal(){
        boolean cloud[][] = new boolean[n][n];
        boolean temp[][] = new boolean[n][n];
        cloud[n-1][0] = true;
        cloud[n-1][1] = true;
        cloud[n-2][0] = true;
        cloud[n-2][1] = true;
        for(int[] command : commands){
//            print();
            int dir = command[0]-1;
            int distance = command[1];
//            System.out.println(dir+" "+distance);
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(cloud[i][j]){
                        int ny = (i + distance * dy[dir] + distance * n) % n;
                        int nx = (j + distance * dx[dir] + distance * n) % n;

                        map[ny][nx]++;
                        cloud[i][j] = false;
                        temp[ny][nx] = true;
                    }
                }
            }
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(temp[i][j]) {
                        rain(i,j);
                    }
                }
            }
//            print();
            for(int i = 0 ; i < n ; i++){
                for(int j = 0; j < n ; j++){
                    if(!temp[i][j] && map[i][j] >= 2){
                        map[i][j] -= 2;
                        cloud[i][j] = true;
                    }else if(temp[i][j]){
                        temp[i][j] = false;
                    }
                }
            }

        }
    }
    static void rain(int y, int x){

        for(int i = 0 ; i < 4; i++){
            int ny = y + rainDy[i];
            int nx = x + rainDx[i];
            if(nx >= 0 && nx < n && ny>=0 && ny < n && map[ny][nx] != 0){
                map[y][x]++;
            }
        }
    }
    static int sum(){
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                result += map[i][j];
            }
        }
        return result;
    }
    static void print(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new int[n][n];
        commands = new int[m][2];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            commands[i][0] = a;
            commands[i][1] = b;
        }
        cal();
        System.out.println(sum());
    }
}
