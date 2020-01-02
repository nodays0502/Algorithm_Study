#include<iostream>
using namespace std;

long long solution(int w, int h)
{
	long long sum;
	int gcd ;
	if (w > h)
		gcd = h;
	else
		gcd = w;
	while (gcd > 1)
	{
		if (w % gcd ==0 && h % gcd == 0) break;
		gcd--;
	}
	sum = w * h - gcd * (w / gcd + h / gcd - 1);
	return sum;
}


int main()
{
	
}