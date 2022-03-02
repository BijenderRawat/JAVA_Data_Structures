import java.util.Arrays;
public class Sum_0_Triplet{
	private static boolean twoSum(int [] arr, int i, int x){
		int j = arr.length-1;
		while(i < j){
			if(arr[i]+arr[j] < x) i++;
			else if(arr[i]+arr[j] > x) j--;
			else return true;
		}
		return false;
	}
//  This function prints 1 if their is a triplet whose sum is 0 and 0 if not.	
	private static void threeSum(int [] arr){
		Arrays.sort(arr);
		for(int i = 0; i < arr.length-2; i++){
			if(twoSum(arr, i+1, -arr[i])){
				System.out.print('1');
				return;
			}
		}
		System.out.print('0');
	}
	public static void main(String [] args){
		int [] arr = {2, 4, -1, 3, -4, 0, 3};
		threeSum(arr);
	}
}