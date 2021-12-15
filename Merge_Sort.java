import java.util.Scanner;
public class Merge_Sort{
	
//  funtion to re-join divided arrayay segments into one	
	static void conquer(int [] array, int si, int mid, int ei){
		
		int [] merged = new int[ei-si+1];
		int idx1 = si, idx2 = mid+1, x = 0;
		while(idx1 <= mid && idx2 <= ei){
			if(array[idx1] <= array[idx2]) merged[x++] = array[idx1++];
			else merged[x++] = array[idx2++];
		}
		while(idx1 <= mid){
			merged[x++] = array[idx1++];
		}
		while(idx2 <= ei){
			merged[x++] = array[idx2++];
		}
		for(int i = 0, j = si; i < merged.length; i++, j++){
			array[j] = merged[i];
		}
		
	}
	
//  function to divide arrayay into sub-arrayays	
	static void divide(int [] array, int si, int ei){
		
		if(si >= ei) return;
		int mid = (si + ei) / 2;
		divide(array, si, mid);
		divide(array, mid+1, ei);
		conquer(array, si, mid, ei);
	
	}
	
	public static void main(String [] args){
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter size of array ");
		int [] array = new int[scn.nextInt()];
		System.out.println("Enter the array");
		for(int i = 0; i < array.length; i++){
			array[i] = scn.nextInt();
		}
		divide(array, 0, array.length-1);
		for(int i : array){
			System.out.print(i + " ");
		}
		
	}
}