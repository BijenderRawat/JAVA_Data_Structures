import java.util.Scanner;

public class Rain_Water_Trapping {
	
	static void trap(int [] array) {
		
		int [] left = new int[array.length];
		int [] right = new int[array.length];
		left[0] = array[0];
		right[array.length-1] = array[array.length-1];
		for(int i = 1; i < array.length; i++) {
			left[i] = Math.max(array[i], left[i-1]);
			right[array.length-1-i] = Math.max(array[array.length-1-i], right[array.length-i]);
		}
		int ans = 0;
		for(int i = 0; i < array.length; i++) {
			ans += Math.min(left[i], right[i])-array[i];
		}
		System.out.print("Total trapped water = " + ans);
		
	}

	public static void main(String[] args) {
		
//		It's a very basic and important question related to array concept
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of buildings");
		int size = scn.nextInt();
		int [] array = new int[size];
		
//		Taking input for heights of buildings
		for(int i = 0; i < size; i++) array[i] = scn.nextInt();
		trap(array);
		scn.close();

	}

}
