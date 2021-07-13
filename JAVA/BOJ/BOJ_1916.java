package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class MyNode{
    int end;
    int weight;
    public MyNode(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class BOJ_1916 {
    static int n ,m,start,end;
    static List<MyNode>[] map;
    static int dij(){
        boolean visited[] = new boolean[n+1];
        int distance[] = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        for( int i = 0 ; i < n ; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && min > distance[j]){
                    min = distance[j];
                    minIndex = j;
                }
            }
            if(minIndex == end) return min;
            visited[minIndex] = true;
//            System.out.println(minIndex);
//            System.out.println(map[minIndex].size());
            for(int j = 0 ; j < map[minIndex].size() ; j++){
                int next = map[minIndex].get(j).end;
                int weight = map[minIndex].get(j).weight;
                if(!visited[next] && distance[next] > min + weight){
                    distance[next] = min + weight;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        map = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new MyNode(b,c));
        }
        st = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        System.out.println(dij());
    }
}
