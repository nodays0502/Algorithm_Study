#include<iostream>
#include<vector>
using namespace std;
int solution(string s);
int main()
{
	int num;
	string temp;
	while (1)
	{
		cin >> temp;
		num=solution(temp);
		cout << num;
	}
}
int solution(string s) {
	int answer = 10001;
	int size = s.length();
	int count;
	int keep;
	if (size == 1)
		return 1;
	else {
		for (int j = 1; j <= (size / 2); j++)
		{
			keep = 1;
			count = size;
			for (int i = 0; i < size;)
			{
				if (i + j < size)
				{
					if (s.substr(i, j) == s.substr(i + j, j))
					{
						count = count - j; // 중복 단어 제거
						keep++;
					}
					else if (keep >1)
					{
							if (keep < 10)
							{
								count++; // 개수 숫자
							}
							else if (keep < 100)
							{
								count += 2;
							}
							else if (keep < 1000)
							{
								count += 3;
							}
						keep = 1;
					}
					else keep =1;
				}
				i += j;
			}
			if (keep>1)
			{
				if (keep < 10)
				{
					count++; // 개수 숫자
				}
				else if (keep < 100)
				{
					count += 2;
				}
				else if (keep < 1000)
				{
					count += 3;
				}
			}
			if (count < answer) answer = count;
		}
	}
	return answer;
}
