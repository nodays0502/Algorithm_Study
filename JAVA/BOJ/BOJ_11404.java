package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11404 {
    static int n;
    static int m;
    static int map[][];
    static void floyd(){
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(i != j && j != k && k != i && map[i][k] != 0 && map[k][j] != 0){
                        if(map[i][j] == 0){
                            map[i][j] = map[i][k] + map[k][j];
                        }else{
                            map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        map = new int[n+1][n+1];
        m = stoi.apply(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            if(map[a][b] == 0) {
                map[a][b] = c;
            }else{
                map[a][b] = Math.min(map[a][b],c);
            }
        }
        floyd();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
