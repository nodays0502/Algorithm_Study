package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2210 {
    static int map[][];
    static Set<String> set = new HashSet<>();
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static void dfs(int depth,StringBuilder sb, int y , int x){
//        System.out.println(y+" "+x);
        if(depth == 6){
            set.add(sb.toString());
        }else{
            for(int i = 0 ; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5){
                    StringBuilder temp = new StringBuilder(sb.toString());
                    temp.append(map[ny][nx]);
                    dfs(depth + 1, temp,ny,nx);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        Function<String,Integer> stoi = Integer::parseInt;
        map = new int[5][5];
        for(int i = 0 ; i < 5; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 5; j++){
//                System.out.println(i+" "+j);
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        for(int i = 0 ; i < 5; i++){
            for(int j = 0 ; j < 5; j++){
                dfs(0,new StringBuilder(),i,j);
            }
        }
//        for (String s : set) {
//            System.out.println(s);
//        }
        System.out.println(set.size());
    }
}
