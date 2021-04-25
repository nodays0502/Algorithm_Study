package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TreeNode{
	char value;
	TreeNode left;
	TreeNode right;
	public TreeNode(char value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public TreeNode(char value) {
		super();
		this.value = value;
	}
}
class Tree{
	TreeNode root;
	public void add(char value, char leftData, char rightData) {
		if(root == null) {
			if(value != '.') {
				root = new TreeNode(value); 
			}
			if(leftData!='.') {
				root.left = new TreeNode(leftData);
			}
			if(rightData != '.') {
				root.right = new TreeNode(rightData);
			}
		}
		else search(root,value,leftData,rightData);
	}
	public void search(TreeNode root , char data, char leftData,char rightData) {
		if(root == null)return ;
		else if(root.value == data) {
			if(leftData != '.') {
				root.left = new TreeNode(leftData);
			}
			if(rightData != '.') {
				root.right = new TreeNode(rightData);
			}
		}
		else {
			search(root.left,data,leftData,rightData);
			search(root.right,data,leftData,rightData);			
		}
	}
	public void preOrder(TreeNode root) {
		System.out.print(root.value);
		if(root.left != null) preOrder(root.left);
		if(root.right != null) preOrder(root.right);
	}
	public void inOrder(TreeNode root) {
		if(root.left != null) inOrder(root.left);
		System.out.print(root.value);
		if(root.right != null) inOrder(root.right);
	}
	public void postOrder(TreeNode root) {
		if(root.left != null) postOrder(root.left);
		if(root.right != null) postOrder(root.right);
		System.out.print(root.value);
	}
}
public class BOJ_1991 {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		Tree tree = new Tree();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			char root = st.nextToken().charAt(0);
			char child1 = st.nextToken().charAt(0);
			char child2 = st.nextToken().charAt(0);
			tree.add(root, child1, child2);
		}
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
	
}
