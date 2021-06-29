package self;

public class 합승_택시_요금 {
    static final int LIMIT = 100001;
    static int map[][];
    static void prim(int n){
        for(int k = 1 ; k <= n ; k ++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(i != j && j != k && k != i && map[i][k] != 0 && map[k][j] != 0){
                        if(map[i][j] == 0)
                            map[i][j] = map[i][k] + map[k][j];
                        else
                            map[i][j] = Math.min(map[i][j] , map[i][k] + map[k][j]);
                    }
                }
            }
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        map = new int[n+1][n+1];
        for(int i = 0 ; i < fares.length ; i++){
            int x = fares[i][0];
            int y = fares[i][1];
            int z = fares[i][2];
            map[x][y] = z;
            map[y][x] = z;
        }
        prim(n);
        int result = Integer.MAX_VALUE;
        for(int k = 1 ; k <= n ; k ++){
            if((s == k || map[s][k] != 0 ) && (k == a || map[k][a] != 0) 
                && (k == b || map[k][b] != 0))
                result = Math.min(result,map[s][k] + map[k][a] + map[k][b]);
     //               System.out.println(result);

        }
        answer = result;
  //      System.out.println(Arrays.deepToString(map));
        return answer;
    }
}