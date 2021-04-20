class Solution {
    static int dp[][];
    static int size;
    static int dfs(int y , int x,int[][]triangle){
        int result =  0;
        if(y == size) return 0;
        if(dp[y][x] != 0) return dp[y][x];
        result = Math.max(dfs(y+1,x,triangle),dfs(y+1,x+1,triangle));
        result += triangle[y][x];
        dp[y][x] = result;
        return result;
    }
    public int solution(int[][] triangle) {
        int answer = 0;
        size = triangle.length;
        dp = new int [size][size];
        answer = dfs(0,0,triangle);
        return answer;
    }
}
