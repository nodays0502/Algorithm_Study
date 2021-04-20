class Solution {
    static int dp1[];
    static int dp2[];
    public int solution(int[] money) {
        int answer = 0;
        dp1 = new int[money.length]; // 첫번째 털음 , 마지막 못텀
        dp2 = new int[money.length]; // 첫번쨰 안텀
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0],money[1]);
        dp2[1] = money[1];
        int size = money.length;
        for(int i = 2 ; i < size;i++){
            if(i != size-1)
                dp1[i] = Math.max(dp1[i-1],dp1[i-2]+ money[i]) ;
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+ money[i]) ;
        }
        answer = Math.max(dp1[size-2],dp2[size-1]);
        if(size == 3){
            answer = Math.max(answer,money[2]);
        }
        return answer;
    }
}
