package Algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Algo_06_BOGGLE {
    static int LIMIT = 5;
    static int dy[] = {-1,0,1,0,-1,1,1,-1};
    static int dx[] = {0,1,0,-1,1,1,-1,-1};
    static char map[][] = new char[LIMIT][LIMIT];
    static int visited[][][];
    static int cal(int depth, String str, int y, int x){
        char now = str.charAt(depth);
//        System.out.println(y+" "+x);
        if(now != map[y][x]){ // 일치하는지 확인
            return -1;
        }
        if(visited[depth][y][x] != 0){ // 처음인지 확인
            return visited[depth][y][x];
        }
        if(depth == str.length()-1){ // 기저조건
//            System.out.println(y+" "+x);
            return 1;
        }else{
            int result = -1;
            for(int i = 0 ; i < 8 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(nx >= 0 && nx < LIMIT && ny >= 0 && ny < LIMIT){
                    int temp = cal(depth+1,str,ny,nx);
                    if(temp == 1){
//                        System.out.println(y+" "+x);
                        result = 1;
                        break;
                    }
                }
            }
            visited[depth][y][x] = result;
            return result;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test; t++){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < LIMIT ; i++){
                String command = br.readLine();
                for(int j = 0 ; j < LIMIT; j++){
                    map[i][j] = command.charAt(j);
                }
            }
            st = new StringTokenizer(br.readLine()," ");
            int m = stoi.apply(st.nextToken());
            for(int k = 0 ; k < m ; k++){
                String command = br.readLine();
                visited = new int[command.length()][LIMIT][LIMIT];
                for(int i = 0 ; i < command.length() ; i++){
                    for(int j = 0 ; j < LIMIT ; j++){
                        for(int l = 0 ; l < LIMIT ; l++){
                            visited[i][j][l] = 0 ;
                        }
                    }
                }
                int flag = -1;
                for(int i = 0 ; i < LIMIT; i++){
                    for(int j = 0 ; j < LIMIT; j++){
                        flag = cal(0,command,i,j);
                        if(flag == 1){
                            break;
                        }
                    }
                    if(flag == 1){
                        break;
                    }
                }
                if(flag == 1){
//                    System.out.println(command +" YES");
                    sb.append(command);
                    sb.append(" YES\n");
                }else{
//                    System.out.println(command +" NO");
                    sb.append(command);
                    sb.append(" NO\n");
                }
            }
            System.out.print(sb.toString());
        }
    }
}
