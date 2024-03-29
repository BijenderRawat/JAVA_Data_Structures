import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

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
	
	// Another method to print left view of tree using array
	static void leftview(Node root, int [] array, int level){
		if(root == null) return;
		if(array[level] == 0) array[level] = root.data;
		leftview(root.left, array, level+1);
		leftview(root.right, array, level+1);
	}
	static void printleftview(Node root){
		int [] array = new int[height(root)];
		leftview(root, array, 0);
		for(int i : array) System.out.print(i + " ");
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
	
	// Another method to print right view of tree using array
	static void rightview(Node root, int [] array, int level){
		if(root == null) return;
		if(array[level] == 0) array[level] = root.data;
		rightview(root.right, array, level+1);
		rightview(root.left, array, level+1);
	}
	static void printrightview(Node root){
		int [] array = new int[height(root)];
		rightview(root, array, 0);
		for(int i : array) System.out.print(i + " ");
	}
	
	
	// Top view of tree would be
	static void topview(Node root, HashMap<Integer, Node> map, int level){
		if(root == null) return;
		map.putIfAbsent(level, root);
		topview(root.left, map, level-1);
		topview(root.right, map, level+1);
	}
	static void printtopview(Node root){
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		topview(root, map, 0);
		for(Node current : map.values()) System.out.print(current.data + " ");
		System.out.println("\nTop view from left to right");
		TreeMap<Integer, Node> treemap = new TreeMap<Integer, Node>(map);
		for(Node current : treemap.values()) System.out.print(current.data + " ");
	}
	
	// Bottom view of tree would be
	static void bottomview(Node root, HashMap<Integer, Node> map, int level){
		if(root == null) return;
		map.put(level, root);
		bottomview(root.left, map, level-1);
		bottomview(root.right, map, level+1);
	}
	static void printbottomview(Node root){
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		bottomview(root, map, 0);
		for(Node current : map.values()) System.out.print(current.data + " ");
		System.out.println("\nBottom view from left to right");
		TreeMap<Integer, Node> treemap = new TreeMap<Integer, Node>(map);
		for(Node current : treemap.values()) System.out.print(current.data + " ");
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
		
		System.out.println("\nLeft view of tree using array");
		printleftview(root);
		
		System.out.println("\nRight view of tree would be");
		rightview(root);
		
		System.out.println("\nRight view of tree using array");
		printrightview(root);
		
		System.out.println("\nTop view of tree would be");
		printtopview(root);
		
		System.out.println("\nBottom view of tree woould be");
		printbottomview(root);
		
	}
}