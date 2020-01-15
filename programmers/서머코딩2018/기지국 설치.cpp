int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    int i;
    int width = 2 * w + 1;
    answer += ceil((stations[0] - 1 - w) / (double)width);
    for (i = 1; i < stations.size(); i++)
    {
        answer += ceil((stations[i] - stations[i - 1] -1 -2*w)/(double)width);
    }
    answer += ceil((n - stations[i - 1] - w) / (double)width);
    return answer;
}
