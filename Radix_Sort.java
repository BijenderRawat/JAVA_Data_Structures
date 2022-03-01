public class Radix_Sort{
	static int getmax(int [] array){
		int max = Integer.MIN_VALUE;
		for(int i : array) if(max < i) max = i;
		return max;
	}
	static void sort(int [] array, int n, int place){
		int [] output = new int[n+1];		
		int [] count = new int[10];
		
//      Every position must know, how many numbers want that position		
		for(int i = 0; i < n; i++) count[(array[i]/place)%10]++;
		
//      Every position in count array must know the number of numbers before its position		
		for(int i = 1; i < 10; i++) count[i] += count[i-1];
		
//      Now, this loop will chose and place the number from array to its most suitable place in output array 		
		for(int i = n-1; i >= 0; i--){
			output[count[(array[i]/place)%10]-1] = array[i];
			count[(array[i]/place)%10]--;
		}
		
//      Replacing array with output array		
		for(int i = 0; i < n; i++) array[i] = output[i];
	}
	static void radix_sort(int [] array){
		int n = array.length;		
		int max = getmax(array);
		
//      The loop will run the number of times equal to the number of digits in maximum number from array		
		for(int place = 1; max/place > 0; place *= 10) sort(array, n, place);
	}
	public static void main(String [] args){
		int [] array = {170, 45, 75, 90, 802, 24, 2, 66};
		radix_sort(array);
		for(int i : array) System.out.print(i + " ");
	}
}