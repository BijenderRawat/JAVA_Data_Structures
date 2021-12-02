import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Node{
	Node left, right;
	int data;
	Node(int data){
		this.data = data;
	}
}

public class Tree{
	
	static Scanner scn = new Scanner(System.in);
	
	
	// Function to create Tree for us
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
	
	// Function to print Inorder traversal in tree
	static void inorder(Node root){
		
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
		
	}
	
	// Functon to print Preorder traversal in tree
	static void preorder(Node root){
		
		if(root == null) return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		
	}
	
	// Function to print Postorder traversal in tree
	static void postorder(Node root){
		
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
		
	}
	
	// Function to print height of tree
	static int height(Node root){
		
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right))+1;
		
	}
	
	// Function to print size i.e number of nodes in the tree
	static int size(Node root){
		
		if(root == null) return 0;
		return size(root.left) + size(root.right) + 1;
		
	}
	
	// Funtion to print maximum number in Tree
	static int max(Node root){
		
		if(root == null) return Integer.MIN_VALUE;
		return Math.max(root.data, Math.max(max(root.left), max(root.right)));
		
	}
	
	// Function to print minimum number in Tree
	static int min(Node root){
		
		if(root == null) return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min(min(root.left), min(root.right)));
		
	}
	
	// Funtion to print Level Order Traversal in Tree
	static void LevelOrderTraversal(Node root){
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node current = q.poll();
			System.out.print(current.data + " ");
			if(current.left != null) q.add(current.left);
			if(current.right != null) q.add(current.right);
		}
		
	}
	
	// Function to print Left View of Tree
	static void leftview(Node root){
		
		if(root == null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i = 1; i <= size; i++){
				Node current = q.poll();
				if(i == 1) System.out.print(current.data + " ");
				if(current.left != null) q.add(current.left);
				if(current.right != null) q.add(current.right);
			}
		}
		
	}
	
	// Function to print Right View of Tree
	static void rightview(Node root){
		
		if(root == null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i = 1; i <= size; i++){
				Node current = q.poll();
				if(i == 1) System.out.print(current.data + " ");
				if(current.right != null) q.add(current.right);
				if(current.left != null) q.add(current.left);
			}
		}
	
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
		
		System.out.println("Size of Tree is");
		System.out.println(size(root));
		
		System.out.println("Maximum number in the Tree is");
		System.out.println(max(root));
		
		System.out.println("Minimum number of the Tree is");
		System.out.println(min(root));
		
		System.out.println("level order Traversal in list");
		LevelOrderTraversal(root);
		
		System.out.println("\nLeft view of tree would be");
		leftview(root);
		
		System.out.println("\nRight view of tree would be");
		rightview(root);
		
		
	}
}
