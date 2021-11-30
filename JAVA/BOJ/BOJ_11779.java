package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11779 {
    static int map[][];
    static int n;
    static int m;
    static final int LIMIT = 100000;
    static int dij(int start, int end){
        boolean visited[] = new boolean[n+1];
        int route[] = new int[n+1];
        int distance[] = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        for(int i = 1 ; i <= n ; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && min > distance[j]){
                    min = distance[j];
                    minIndex = j;
                }
            }
//            System.out.println(minIndex);
            visited[minIndex] = true;
            if(minIndex == end){
                Deque<Integer> stack = new LinkedList<>();
                while(route[minIndex] != 0){
                    stack.addFirst(minIndex);
                    minIndex = route[minIndex];
                }
                stack.addFirst(minIndex);
                System.out.println(min);
                System.out.println(stack.size());
                while(!stack.isEmpty()){
                    System.out.print(stack.pollFirst()+" ");
                }
                System.out.println();
//                System.out.println(Arrays.toString(distance));
//                System.out.println(Arrays.toString(route));
                return min;
            }
//            System.out.println(minIndex);
//            System.out.println(Arrays.toString(distance));
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && map[minIndex][j] != LIMIT && min + map[minIndex][j] <= distance[j]){
                    route[j] = minIndex;
                    distance[j] = min + map[minIndex][j];
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        m = stoi.apply(st.nextToken());
        map = new int[n+1][n+1];
        for(int i = 0 ; i <= n; i++){
            Arrays.fill(map[i],LIMIT);
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a][b] = Math.min(map[a][b],c);
        }
        st = new StringTokenizer(br.readLine()," ");
        int a = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());
        dij(a,b);
    }
}
