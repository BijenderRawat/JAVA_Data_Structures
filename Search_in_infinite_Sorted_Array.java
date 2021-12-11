import java.util.Scanner;

public class Search_in_infinite_Sorted_Array{
	
	static void binary_search(int [] array, int key, int low, int high){
		
		while(low < high){
			int mid = (low + high) / 2;
			if(array[mid] == key){
				System.out.print(key + " found at " + (mid+1) + " position");
				break;
			}
			if(key < array[mid]) high = mid-1;
			else low = mid+1;
		}
		if(low > high) System.out.print(key + " is not present in array");
		
	}
	
	static void search_infinite(int [] array, int key){
		
		int low = 0, high = 1;
		while(array[high] < key){
			low = high;
			high *= 2; 
		}
		binary_search(array, key, low, high);
	}
	
	public static void main(String [] args){
		
/*		In an infinte sorted array, the number which we want to find can be anywhere. 
		By applying brute force method to find the number, T(n) = O(n)
		
		we can use the searching alog. in terms of range. i.e, we can search for the number in a specific range.
		But even searching in range, T(n) = O(n) because, for a specific range, the size of infinte array will be greater always
		
		suppose ek infinte array ki length 1000 hai, or humne range of numbers 200 maan li, ye range iske liye theek hai
		pr suppose array ki length 1 million ho gayi, to ye range iske liye theek nahi hogi, iske liye or badi range chahiye
		
		we can conclude that we need to increase the range time to time
		we need to make sure that range increase exponentially, because that exponential growth of range will take our time complexity of algorithm to log(n)
		
*/
        	Scanner scn = new Scanner(System.in);
		System.out.println("Enter how many numbers you want to insert ");
		int n = scn.nextInt();
		int [] array = new int[n];
		for(int i = 0; i < n; i++) array[i] = scn.nextInt();
		System.out.println("Enter the number you want to search ");
		search_infinite(array, scn.nextInt());
		
	}
}
