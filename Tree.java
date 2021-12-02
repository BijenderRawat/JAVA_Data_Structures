import java.util.Scanner;

class Node{
	Node left, right;
	int data;
	Node(int data){
		this.data = data;
	}
}

public class Tree{
	
	static Scanner scn = new Scanner(System.in);
	
	public static Node createTree(){
		
		System.out.println("Enter Data");
		int data = scn.nextInt();
		if(data == -1) return null;
		Node root = new Node(data);
		System.out.println("Enter Left Data for " + root.data);
		root.left = createTree();
		System.out.println("Enter Right Data for " + root.data);
		root.right = createTree();
		return root;
		
	}
	
	static void inorder(Node root){
		
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
		
	}
	
	static void preorder(Node root){
		
		if(root == null) return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		
	}
	
	static void postorder(Node root){
		
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
		
	}
	
	static int height(Node root){
		
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right))+1;
		
	}
	
	static int size(Node root){
		
		if(root == null) return 0;
		return size(root.left) + size(root.right) + 1;
		
	}
		
	
	public static void main(String [] args){
		
		Node root = createTree();
		
		System.out.println("In Order Traversal");
		inorder(root);
		
		System.out.println("\nPre Order Traversal");
		preorder(root);
		
		System.out.println("\nPost Order Traversal");
		postorder(root);
		
		System.out.println("\nHeight Of Tree is");
		System.out.println(height(root));
		
		// Size of Tree means total number of nodes in the tree
		System.out.println("Size of Tree is");
		System.out.println(size(root));
		
		
	}
}