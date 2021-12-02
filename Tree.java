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
		
	
	public static void main(String [] args){
		
		Node root = createTree();
		
		System.out.println("In Order Traversal");
		inorder(root);
		
		System.out.println("\nPre Order Traversal");
		preorder(root);
		
		System.out.println("\nPost Order Traversal");
		postorder(root);
		
		
	}
}