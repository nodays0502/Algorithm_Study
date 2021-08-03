package BOJ;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1717 {

    static int n, m;
    static int parent[];

    static int findParent(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = findParent(parent[a]);
        }
    }

    static boolean setUnion(int a, int b) {
        int aParent = findParent(a);
        int bParent = findParent(b);
        if (aParent == bParent) {
            return false;
        } else {
            parent[bParent] = aParent;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        parent = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = stoi.apply(st.nextToken());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            if (command == 0) {
                setUnion(a, b);
            } else {
                int aParent = findParent(a);
                int bParent = findParent(b);
                if(aParent == bParent){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}
