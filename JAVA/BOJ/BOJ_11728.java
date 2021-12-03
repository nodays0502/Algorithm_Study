package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11728 {

    static int n, m;
    static int input[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        input = new int[2][];
        input[0] = new int[n];
        input[1] = new int[m];
        for (int i = 0; i < n; i++) {
            input[0][i] = stoi.apply(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            input[1][i] = stoi.apply(st.nextToken());
        }
        int si1 = 0;
        int si2 = 0;
        StringBuilder sb = new StringBuilder();
        while(si1 < n || si2 < m){

            if(si1 == n){
//                System.out.print(input[1][si2++]);
                sb.append(input[1][si2++]);
            } else if(si2 == m){
//                System.out.print(input[0][si1++]);
                sb.append(input[0][si1++]);
            } else if(input[0][si1] < input[1][si2]){
//                System.out.print(input[0][si1++]);
                sb.append(input[0][si1++]);
            }else{
//                System.out.print(input[1][si2++]);
                sb.append(input[1][si2++]);
            }
//            System.out.print(" ");
            sb.append(" ");
//            System.out.printf("%d %d %d %d \n", si1,si2,n,m);
        }
        System.out.println(sb.toString());
    }
}
