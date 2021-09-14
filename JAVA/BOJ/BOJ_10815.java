package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10815 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> number = new HashSet<>();
        int n, m;
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            number.add(stoi.apply(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < m ; i++){
            if(number.contains(stoi.apply(st.nextToken()))){
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }
        }
    }
}
