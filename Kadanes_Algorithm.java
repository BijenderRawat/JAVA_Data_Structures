import java.util.Scanner;

public class Kadanes_Algorithm {
	
	public static void maxsubarray(int [] array) {
		
		int a = 0, b = Integer.MIN_VALUE, left = 0, right = 0;
		for(int i = 0; i < array.length; i++){
			a += array[i];
			if(a < array[i]) {
				a = array[i];
				left = i;
			}
			if(b < a){
				b = a;
				right = i;
			}
		}
		System.out.println("Max SubArray ");
		for(int i = left; i <= right; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println("\nMax Sum = " + b);
				
	}

	public static void main(String[] args) {
		
//		It's an algorithm to find the sub array with the largest sum among all the sub arrays
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = scn.nextInt();
		int [] array = new int[size];
		for(int i = 0; i < size; i++) array[i] = scn.nextInt();
		maxsubarray(array);
		scn.close();

	}

}