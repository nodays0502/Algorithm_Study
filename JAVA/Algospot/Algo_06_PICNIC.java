package Algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Algo_06_PICNIC {
    static int n,m;
    static boolean map[][];
    static boolean visited[];
    static int cal(){
        int first = -1;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                first = i;
                break;
            }
        }
        if(first == -1){
            return 1;
        }
        for(int i = first + 1; i < n ; i++){
            if(!visited[i] && map[first][i]){
                visited[i] = visited[first] = true;
                result += cal();
                visited[i] = visited[first] = false;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine()," ");
            n = stoi.apply(st.nextToken());
            m = stoi.apply(st.nextToken());
            map = new boolean[n][n];
            visited = new boolean[n];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0 ; i < m ; i++){
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                map[a][b] = true;
                map[b][a] = true;
            }
            System.out.println(cal());
        }
    }
}
