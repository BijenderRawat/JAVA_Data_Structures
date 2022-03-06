import java.util.Scanner;

class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
	}
}

public class Lowest_Comman_Ancestor{
	
	public static Scanner scn = new Scanner(System.in);
	
	public static Node createTree() {	
		System.out.println("Enter data: ");
		int data = scn.nextInt();
		if(data == -1) return null;
		Node root = new Node(data); 
		System.out.println("Enter left data for " + data);
		root.left = createTree();
		System.out.println("Enter right data for " + data);
		root.right = createTree();
		return root;
	}
	
	static boolean b = true;
	static boolean checkforpresence(Node root, int d) {
		if(root == null) return false;
		if(root.data == d) return true;
		return (checkforpresence(root.left, d) || checkforpresence(root.right, d));
	}
	
	static Node lowestCommanAncestor(Node root, int d1, int d2) {
//		first, we need to check whether both the elements are present in the tree
//		if we don't check it then the output will be given even if only one element is present in the tree
		if(b) {
			if(checkforpresence(root, d1) && checkforpresence(root, d2) == false) return null;
			b = false;
		}
		if(root == null) return null;
		if(root.data == d1 || root.data == d2) return root;
		Node left = lowestCommanAncestor(root.left, d1, d2);
		Node right = lowestCommanAncestor(root.right, d1, d2);
		if(left == null) return right;
		if(right == null) return left;
		return root;
	}
	
	public static void main(String [] args){
		
		Node root = createTree();
		
		System.out.println("Enter 2 numbers");
		int d1 = scn.nextInt();
		int d2 = scn.nextInt();
		if(lowestCommanAncestor(root, d1, d2) == null) System.out.print("Either one or both elements are not present");
		else System.out.print("Lowest Comman Ancestor of " + d1 + " and " + d2 + " is " + lowestCommanAncestor(root, d1, d2).data);
	
	}
}