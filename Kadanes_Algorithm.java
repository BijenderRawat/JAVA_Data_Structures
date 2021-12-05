import java.util.Scanner;
import java.util.Stack;

public class Kadanes_Algorithm {
	
	public static void maxsubarray(int [] array) {
		
		int sum1 = 0, sum2 = 0, temp = 0;
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		for(int i = 0; i < array.length; i++) {
			if(!s2.isEmpty()) {
				if(sum1 < array[i]) {
					s1.clear();
					s2.clear();
					s1.push(array[i]);
				}
				else if(sum2 + array[i] > sum1) {
					s1.addAll(s2);
					s2.clear();
					s1.push(array[i]);
					sum1 = sum2 + array[i];
					sum2 = 0;
				}
				else if(sum2 + array[i] == sum1){
					s1.clear();
					s1.push(array[i]);
					s2.clear();
					sum2 = 0;
				}
				else {
					if(array[i] >= 0 && temp != 0 && s2.peek() < 0) {
						temp += array[i];
						s2.push(array[i]);
						sum2 += array[i];
					}else if(array[i] < 0) {
						s2.push(array[i]);
						sum2 += array[i];
					}
				}
			}
			else if(sum1 + array[i] == 0) {
				s1.clear();
				sum1 = 0;
			}
			else if(sum1 + array[i] > sum1) {
				s1.push(array[i]);
				sum1 += array[i];
			}else {
				s2.push(array[i]);
				sum2 = sum1 + array[i];
			}
		}
		int maxsum = 0;
		System.out.println("Max SubArray");
		for(int i : s1) {
			System.out.print(i + " ");
			maxsum += i;
		}
		System.out.println("\nMax Sum = " + maxsum);
		
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