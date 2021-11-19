package Codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class NO_1294_A {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            int n = stoi.apply(st.nextToken());
            int max = Math.max(a,b);
            max = Math.max(max,c);
            int temp = max - a;
            temp += max - b;
            temp += max - c; // 각각의 차이
            n -= temp; // 맞춰준다.
//            System.out.printf("a:%d b:%d c:%d temp:%d n:%d \n",a,b,c,temp,n);
            if(n >= 0 && n % 3 == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
