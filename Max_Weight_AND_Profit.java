import java.util.Scanner;

public class Max_Weight_AND_Profit{
	
	static int max(int [] weight, int [] profit, int c, int n){
		
		if(c == 0 || n == 0) return 0;
		if(weight[n-1] > c) return max(weight, profit, c, n-1);
		else return Math.max(profit[n-1] + max(weight, profit, c-weight[n-1], n-1), max(weight, profit, c, n-1));
		
	}
	
	public static void main(String [] args){
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter size ");
		int n = scn.nextInt();
		int [] weight = new int[n];
		System.out.print("Enter weights ");
		for(int i = 0; i < n; i++){
			weight[i] = scn.nextInt();
		}
		int [] profit = new int[n];
		System.out.print("Enter profits ");
		for(int i = 0; i < n; i++){
			profit[i] = scn.nextInt();
		}
		System.out.print("Enter Capacity of bag ");
		int c = scn.nextInt();
		
		System.out.print("Maximum profit = " + max(weight, profit, c, n));
		
	}
}