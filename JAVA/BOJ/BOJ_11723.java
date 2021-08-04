package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
    static int n ;
    static int all = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= 20 ; i++){
            all = all | 1<<i;
        }
//        System.out.println(all);
        n = Integer.parseInt(st.nextToken());
        int now = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if("all".equals(command)){
                now = all;
            }else if("empty".equals(command)){
                now = 0;
            } else {
                int num = Integer.parseInt(st.nextToken());
                int check = 1 << num;
                if("add".equals(command)){
                    now = now | check;
                }else if("remove".equals(command)){
                    now = now & (~check);
                }else if("check".equals(command)){
                    if ((now & check) > 0)
                        sb.append("1\n");
                    else {
                        sb.append("0\n");
                    }
                }else if("toggle".equals(command)){
                    now = now ^ check;
                }
            }
        }
        System.out.println(sb);
    }
}
