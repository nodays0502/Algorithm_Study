#include<iostream>
using namespace std;
int main()
{
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(false);
	int num;
	cin >> num;
	int N, A, B;
	for (int i = 0; i < num; i++)
	{
		cin >> N >> A >> B;
		if (A>B)
			cout << "#" <<i + 1<<" "<< 0 << "\n";
		else if(A == B)
			cout << "#"<<i + 1 << " " << 1 << "\n";
		else if (N == 1) // A != B
			cout << "#" <<i + 1 << " " << 0 << "\n";
		else if(N == 2)
			cout << "#" <<i + 1 << " " << 1 << "\n";
		else
		{
			long long result;
			result = (N - 2) *(long long) B - (N - 2) *(long long) A + 1; //result = (N - 1) * B + A - (B + (N-1)*A);
			cout << "#" <<i + 1 <<" "<< result << "\n";
		}
	}
	return 0;
}
