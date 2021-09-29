class Solution {
    static boolean num[] = new boolean[10];
    public int solution(int[] numbers) {
        int answer = 0;
        for(int number : numbers){
            num[number] = true;
        }
        for(int i = 0 ; i < 10 ; i++){
            if(!num[i])
                answer += i;
        }
        return answer;
    }
}
