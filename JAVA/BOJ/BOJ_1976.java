package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int n,m;
    static int map[][];
    static void floyd(){
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 1 ; j <= n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == j)
                    map[i][j] = 1;
            }
        }
        floyd();
        st = new StringTokenizer(br.readLine()," ");
        int input[] = new int[m];
        for(int i = 0 ; i < m ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        boolean result = true;
        for(int i = 0 ; i < m-1 ; i++){
            int a = input[i];
            int b = input[i+1];
            if(map[a][b] == 0){
                result = false;
                break;
            }
        }
//        System.out.println(Arrays.deepToString(map));
        if(result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
