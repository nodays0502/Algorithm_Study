package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3184_2 {
    static int n,m;
    static char map[][];
    static int sheep,wolf;
    static boolean visited[][];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static void cal(int y,int x){
        visited[y][x] = true;
        if(map[y][x] == 'v'){
            wolf++;
        }else if(map[y][x] == 'o'){
            sheep++;
        }
        for(int i = 0 ; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && map[ny][nx] != '#'){
                cal(ny,nx);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int resultSheep = 0;
        int resultWolf = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
//                System.out.println(i+" "+j);
                if(!visited[i][j] && map[i][j] != '#'){
                    cal(i,j);
                    if(sheep > wolf){
                        resultSheep += sheep;
                    }else{
                        resultWolf += wolf;
                    }
                    sheep = 0;
                    wolf = 0;
                }
            }
        }
        System.out.println(resultSheep+" "+resultWolf);
    }
}
