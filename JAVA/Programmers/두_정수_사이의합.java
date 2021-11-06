class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int cnt = Math.abs(a-b) + 1;
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        answer = (((long)min + max) * cnt) / 2;
        return answer;
    }
}
