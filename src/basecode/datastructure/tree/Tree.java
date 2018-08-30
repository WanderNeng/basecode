package basecode.datastructure.tree;

import java.util.Stack;

//二叉树
public class Tree {
	public Node root;

	//node添加元素 非递归
	public boolean add(Node node) {
		if (root == null) {
			root = node;
			return true;
		}
		Node current = root;
		while (current != null) {
			if (current.val > node.val) {
				if(current.left == null) {
					current.left = node;
				}else {
					current = current.left;
				}
			} else if (current.val < node.val) {
				if(current.right == null) {
					current.right = node;
				}else {
					current = current.right;
				}
			} else {
				return false;
			}
		}
		return true;
	}
	public boolean add(int val) {
		Node node = new Node(val);
		return add(node);
	}
	
	//node 添加元素 递归
	public void add1(Node node, Node ro) {
		if (root == null) {
			root = node;
		}
		Node current = ro;
			if (current.val > node.val) {
				if(current.left == null) {
					current.left = node;
				}else {
					add1(node, current.left);
				}
			} else if (current.val < node.val) {
				if(current.right == null) {
					current.right = node;
				}else {
					add1(node, current.right);
				}
			} else {
				return;
			}
	}
	public void add1(int val) {
		Node node = new Node(val);
		add1(node, root);
	}
	
	//前序遍历 递归版
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	//前序遍历 非递归版 也就是深度遍历
	public void preOrder1(Node node) {
		if(node == null) {
			return;
		}
		Stack<Node> st = new Stack<Node>();
		while(node != null || !st.isEmpty()) {
			while(node != null){
				System.out.println(node.val);
                st.push(node);
                node = node.left;
			}
			if(!st.isEmpty())
            {
				node = st.pop();
                node = node.right;
            }
		}
	}
	
	//中序遍历 递归版 也就是从小到大排序
	public void midOrder(Node node) {
		if(node == null) {
			return;
		}
		midOrder(node.left);
		System.out.println(node.val);
		midOrder(node.right);
	}
	
	//中序遍历 非递归版
	public void midOrder1(Node node) {
		if(node == null) {
			return;
		}
		Stack<Node> st = new Stack<Node>();
		while(node != null || !st.isEmpty()) {
			while(node != null) {
				st.push(node);
				node = node.left;
			}
			if( !st.isEmpty()) {
				node = st.pop();
				System.out.println(node.val);
				node = node.right;
			}
		}
	}
	

}
