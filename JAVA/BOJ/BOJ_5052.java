package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_5052 {
    private static class Tree{
        boolean end = false;
        Tree[] leaf = new Tree[10];

        public boolean insert(String str , int depth){
            if(this.end){
                return false;
            }
            if(str.length() == depth){
                this.end = true;
                return true;
            }
            int now = str.charAt(depth) - '0';
            if(leaf[now] == null){
                leaf[now] = new Tree();
            }
            return leaf[now].insert(str,depth+1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ; t++){
            Tree tree = new Tree();
            boolean flag = true;
            st = new StringTokenizer(br.readLine()," ");
            int n = stoi.apply(st.nextToken());
            String[] input = new String[n];
            for(int i = 0 ; i < n ; i++){
                String now = br.readLine();
                input[i] = now;
            }
            Arrays.sort(input);
            for(int i = 0 ; i < n ; i++){
                if(flag && !tree.insert(input[i],0)){
                    flag = false;
                }
            }

            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
