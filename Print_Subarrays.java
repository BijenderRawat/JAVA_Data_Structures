class Print_Subarrays{
	public static void printSubArrays(int [] array, int start, int end){
		if(end == array.length) return;
		else if(start > end) printSubArrays(array, 0, end+1);
		else{
			for(int i = start; i < end; i++) System.out.print(array[i] + " ");
			System.out.println(array[end]);
			printSubArrays(array, start+1, end);
		}
	}
	public static void main(String [] args){
		int [] array = {1, 2, 3, 4, 5};
		printSubArrays(array, 0, 0);
	}
}