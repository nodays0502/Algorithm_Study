package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Node{
    int end;
    int weight;
    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class BOJ_1238 {
    static int n,m,x;
//    static List<Node>[] map;
    static int map[][];
    static void prim() {
        for (int k = 1; k <= n; k++){
            for(int i = 1; i <= n ; i++ ){
                for(int j = 1; j <= n ; j++){
                    if(i == j || j == k || i == k )continue;
                    if(map[i][j] == 0 && map[i][k] != 0 && map[k][j]!=0)
                        map[i][j] = map[i][k] + map[k][j];
                    else if(map[i][j] != 0 && map[i][k] != 0 && map[k][j]!=0)
                        map[i][j] = Math.min(map[i][j],map[i][k] + map[k][j]);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
        }
        prim();
        int result = 0;
        for(int i = 1 ; i <= n ; i++){
            result = Math.max(result,map[i][x] + map[x][i]);
        }
        System.out.println(result);
    }
}
