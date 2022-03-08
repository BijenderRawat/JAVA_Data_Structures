import java.util.Scanner;
class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
	}
}
class Depth{
	int d;
	Depth(int d){
		this.d = d;
	}
}
public class Min_time_to_burn_tree{
	static Scanner scn = new Scanner(System.in);
	private static Node createTree(){
		System.out.println("Enter data");
		int data = scn.nextInt();
		if(data == -1) return null;
		Node root = new Node(data);
		System.out.println("Enter left data for " + data);
		root.left = createTree();
		System.out.println("Enter right data for " + data);
		root.right = createTree();
		return root;
	}
	private static int height(Node root){
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
//  This method will tell the time in which a tree will completely burn if any one node is burnt	
	private static void burn_tree(Node root, int target){
		Depth depth = new Depth(-1);
		cal_time(root, target, depth);
		System.out.println("Min time to burn the tree will be " + Math.max(temp, time));
	}
	
//  We can calculate the time to burn the tree in both upward and downward direction 	
	static int time, temp;
	private static int cal_time(Node root, int target, Depth depth){
		if(root == null) return 0;
		if(root.data == target){
			depth.d = 1;
//          This line will calculate the burning time of the sub-tree below the node			
			temp = height(root);
			return 1;
		}
		Depth ld = new Depth(-1);
		Depth rd = new Depth(-1);
		int lh = cal_time(root.left, target, ld);
		int rh = cal_time(root.right, target, rd);
		if(ld.d != -1){
			time = Math.max(time, ld.d+1+rh);
			depth.d = ld.d+1;
		}else if(rd.d != -1){
			time = Math.max(time, rd.d+1+lh);
			depth.d = rd.d+1; 
		}
		return Math.max(lh, rh)+1;
	}
	public static void main(String [] args){
		Node root = createTree();
		System.out.println("Enter a node to burn");
		burn_tree(root, scn.nextInt());
		scn.close();
	}
}