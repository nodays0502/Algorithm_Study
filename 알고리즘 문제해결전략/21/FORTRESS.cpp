#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n, y[100], x[100], radius[100];
struct TreeNode {
	vector<TreeNode*> child;
};
int longest;
int height(TreeNode* root);
int solve(TreeNode* root);
TreeNode* getTree(int root);
bool isChild(int parent, int child);
int height(TreeNode* root)
{
	vector<int> heigths;
	for (int i = 0; i < root->child.size(); i++)
		heigths.push_back(height(root->child[i]));
	if (heigths.empty()) return 0;
	sort(heigths.begin(), heigths.end());
	if (heigths.size() >= 2)
		longest = max(longest, 2 + heigths[heigths.size() - 2] + heigths[heigths.size() - 1]);

	return heigths.back() + 1;
}
int solve(TreeNode* root)
{
	longest = 0;
	int h = height(root);
	return max(longest, h);
}
TreeNode* getTree(int root)
{
	TreeNode* ret = new TreeNode();
	for (int ch = 0; ch < n; ch++)
		if(isChild(root,ch))
			ret->child.push_back(getTree(ch));
	return ret;
}
int sqr(int x) { return x * x; }
int sqrdist(int a, int b)
{
	return sqr(y[a] - y[b]) + sqr(x[a] - x[b]);
}
bool encloses(int a, int b)
{
	return radius[a] > radius[b] && sqrdist(a, b) < sqr(radius[a] - radius[b]);
}
bool isChild(int parent, int child)
{
	if (!encloses(parent, child))return false;
	for (int i = 0; i < n; i++)
		if (i != parent && i != child && encloses(parent, i) && encloses(i, child)) return false;
	return true;
}
int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cin >> x[i] >> y[i] >> radius[i];
		}
		TreeNode* T = getTree(0);
		cout << solve(T) << endl;
	}
}
