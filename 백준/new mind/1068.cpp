#include<iostream>
#include<vector>
using namespace std;
int num[51];
int t;
struct node {
	int now;
	vector<node*> child;
};
node* getTree(int here)
{
	node* result = new node();
	result->now = here;
	for(int i =0;i<t;i++)
	{
		if (num[i] == here)
			result->child.push_back(getTree(i));
	}
	return result;
}
int countLeft(node* tree,int del)
{
	int result = 0;
	if (tree->now == del) return 0;
	if (tree->child.empty()) return 1;
	for (int i = 0; i < tree->child.size(); i++)
	{
		if (tree->child[i]->now == del && tree->child.size() == 1) return 1;
		else result += countLeft(tree->child[i], del);
	}
	return result;
}
int main()
{
	node* result;
	cin >> t;
	int root;
	for (int i = 0; i < t; i++)
	{
		cin >> num[i];
		if (num[i] == -1) root = i;
	}
	int del;
	result = getTree(root);
	cin >> del;
	cout<<countLeft(result, del)<<endl;
}
