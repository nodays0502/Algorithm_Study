package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_11720 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer>stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        String command = br.readLine();
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += command.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
