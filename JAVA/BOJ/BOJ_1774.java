package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1774 {
    static int n,m;
    static class Edge{
        int y;
        int x;
        double distance;
        public Edge(int y, int x, double distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                "y=" + y +
                ", x=" + x +
                ", distance=" + distance +
                '}';
        }
    }
    static int map[][];
    static List<Edge> list = new ArrayList<>();
    static int parent[];
    static int findSet(int a){
        if(parent[a] == a) return a;
        else{
            return parent[a] = findSet(parent[a]);
        }
    }
    static boolean union(int a, int b){
        int aParent = findSet(a);
        int bParent = findSet(b);
        if(aParent == bParent){
            return false;
        }
        else{
            parent[aParent] = bParent;
            return true;
        }
    }
    static double kruskal(){
        double result = 0;
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        for(Edge node : list){
            int a = node.y;
            int b = node.x;
            double distance = node.distance;
            if(union(a,b)){
//                System.out.println(result);
                result += distance;
            }
//            System.out.println(Arrays.toString(parent));
        }
        return result;
    }
    static double calDistance(int a, int b){
        return Math.sqrt(Math.pow(map[a][0] - map[b][0],2) + Math.pow(map[a][1] - map[b][1],2));
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        map = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[i][0] = a-1;
            map[i][1] = b-1;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                list.add(new Edge(i,j,calDistance(i,j)));
            }
        }
        for(int i = 0 ;i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken())-1;
            int b = stoi.apply(st.nextToken())-1;
            list.add(new Edge(a,b,0));
        }
        Collections.sort(list,(o1,o2)->{
            if(o1.distance < o2.distance){
                return -1;
            }else if (o1.distance == o2.distance){
                return 0;
            }else{
                return 1;
            }
        });
//        System.out.println(list);
        double result = kruskal();
        System.out.printf("%.2f",result);
    }
}
