package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class Node{
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class BOJ_1753 {
    static int v ,e,k;
    static List<Node>[] map;
    static int[] distance;
    static void dij(){
        distance = new int[v + 1];
        boolean[] visited = new boolean[v + 1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;
        for(int i = 0 ; i < v; i++){
     //       System.out.println(Arrays.toString(distance));
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 1; j <= v ; j++){
                if(!visited[j] && min > distance[j]){
                    min = distance[j];
                    minIndex = j;
                }
            }
            if(minIndex == 0) return ;
            visited[minIndex] = true;

            for(int j = 0; j < map[minIndex].size() ; j++){
                int next = map[minIndex].get(j).end;
                int weight = map[minIndex].get(j).weight;
                if(!visited[next] && distance[next] > min + weight){
                    distance[next] = min + weight;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        k = Integer.parseInt(st.nextToken());
        map =  new ArrayList[v+1];
        for(int i = 0 ; i <= v ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < e ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b,c));
      //      map[b].add(new Node(a,c));
        }
        dij();
        for(int i = 1 ; i <= v ; i++){
            if(distance[i] != Integer.MAX_VALUE)
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
    }
}
