#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;
int x[100], y[100], r[100];
int N;
struct treeNode {
	vector<treeNode*> child;
};
int sqr(int a)
{
	return a * a;
}
bool encloses(int a,int b){
	return r[a] > r[b] && sqr(x[a] - x[b]) + sqr(y[a] - y[b]) < sqr(r[a] - r[b]);
}
bool isChild(int parent,int child)
{
	if (!encloses(parent, child)) return false;
	for (int i = 0; i < N; i++)
		if (parent != i && child != i && encloses(parent, i) && encloses(i, child))
			return false;
	return true;
}
treeNode* getTree(int root)
{
	treeNode* result = new treeNode();
	for (int i = 0; i < N; i++)
		if (isChild(root, i))
			result->child.push_back(getTree(i));
	return result;
}
int longest;
int height(treeNode* root)
{
	vector<int> heights;
	for (int i = 0; i < root->child.size(); i++)
	{
		heights.push_back(height(root->child[i]));
	}
	if (heights.empty()) return 0;
	sort(heights.begin(), heights.end());
	if (heights.size() > 1)
		longest = max(longest, 2 + heights[heights.size() - 2] + heights[heights.size() - 1]);
	return heights.back() + 1;
}
int solve(treeNode* root)
{
	longest = 0;
	int h = height(root);
	return max(longest, h);
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{

		cin >> N;
		for (int i = 0; i < N; i++)
		{
			cin >> x[i] >> y[i] >> r[i];
		}
		treeNode* result = getTree(0);
		cout << solve(result) << endl;
	}
}
