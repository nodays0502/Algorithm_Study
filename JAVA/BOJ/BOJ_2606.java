package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2606 {
    static int parent[];
    static int findSet(int a){
        if(a == parent[a]) return a;
        return parent[a] = findSet(parent[a]);
    }
    static boolean makeUnit(int a , int b){
        int aParent = findSet(a);
        int bParent = findSet(b);
        if(aParent == bParent) return false;
        else{
            parent[bParent] = aParent;
            return true;
        }
    }
    static int n;
    static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        st= new StringTokenizer(br.readLine()," ");
        m = stoi.apply(st.nextToken());
        parent = new int[n+1];
        for(int i = 0; i <= n ; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < m ; i++){
           st= new StringTokenizer(br.readLine()," ");
           int a = stoi.apply(st.nextToken());
           int b = stoi.apply(st.nextToken());
           makeUnit(a,b);
        }
//        System.out.println(Arrays.toString(parent));
        int result = 0 ;
        int parent1 = findSet(1);
        for(int i = 2 ; i < n+1 ; i++){
            if(parent1 == findSet(i)){
                result++;
            }
        }
        System.out.println(result);
    }
}
