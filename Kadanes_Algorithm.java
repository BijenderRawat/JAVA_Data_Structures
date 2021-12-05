import java.util.Scanner;
import java.util.ArrayList;

public class Kadanes_Algorithm {
	
	public static void maxsubarray(int [] array) {
		
		int maxsum = 0, currentsum = 0;
		
		ArrayList<Integer> arraytoprint = new ArrayList<Integer>();
		ArrayList<Integer> arraytoadd = new ArrayList<Integer>();
		
		for(int i = 0; i < array.length; i++) {
			currentsum += array[i];
			if(currentsum > maxsum) {
				maxsum = currentsum;
				arraytoprint.addAll(arraytoadd);
				arraytoprint.add(array[i]);
			}
			else if(currentsum < 0) {
				currentsum = 0;
				arraytoprint.clear();
			}
			else arraytoadd.add(array[i]);
		}
		
		System.out.println("Max SubArray");
		for(int i : arraytoprint) System.out.print(i + " ");
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