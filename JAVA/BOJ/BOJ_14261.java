package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14261 {
    static class Node{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static char color[];
    static int n,m;
    static int parent[];
    static List<Node> list = new ArrayList<>();
    static void init(){
        parent = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            parent[i]= i;
        }
    }
    static int findSet(int a){
        if(a == parent[a]) return a;
        else{
            return parent[a] = findSet(parent[a]);
        }
    }
    static boolean union(int a, int b){
        int aParent = findSet(a);
        int bParent = findSet(b);
        if(aParent == bParent){
            return false;
        }else{
            parent[aParent] = bParent;
            return true;
        }
    }
    static int kruskal(){
        int result = 0;
        Collections.sort(list,(o1,o2)->{
            return o1.weight - o2.weight;
        });
        for(Node node : list){
            if(union(node.start,node.end)){
                result += node.weight;
            }
        }
        int parent = findSet(1);
        for(int i = 1; i <= n ; i++){
            if(parent != findSet(i)){
                return -1;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        color = new char[n+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= n ; i++){
            color[i] = st.nextToken().charAt(0);
        }
        init();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int weight = stoi.apply(st.nextToken());
            if(color[a] != color[b]){
                list.add(new Node(a,b,weight));
            }
        }
        System.out.println(kruskal());
    }
}
