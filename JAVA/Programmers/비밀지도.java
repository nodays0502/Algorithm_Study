class Solution {
    static int[][] result;
    static void cal(int[] arr,int n){
        for(int i = 0 ; i < n ; i++){
            int num = arr[i];
            for(int j = n-1 ; j >= 0 ; j--){
                if(num % 2 == 1){
                    result[i][j] = 1;
                }
                num /= 2;
            }
        }
        
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        result = new int[n][n];
        cal(arr1,n);
        cal(arr2,n);
        for(int i = 0 ; i < n ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n ; j++){
                if(result[i][j] == 1){
                    sb.append('#');
                }else{
                    sb.append(' ');
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
