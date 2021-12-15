public class Merge_Sort{
	static void print(int [] merged){
		for(int i = 0; i < merged.length; i++){
			System.out.print(merged[i] + " ");
		}
	}
	static void conquer(int [] arr, int si, int mid, int ei){
		int [] merged = new int[ei-si+1];
		int i = si, j = mid+1, k = 0;
		while(i <= mid && j <= ei){
			if(arr[i] <= arr[j]){
				merged[k] = arr[i];
				k += 1;
				i += 1;
			}else{
				merged[k] = arr[j];
				k += 1;
				j += 1;
			}
		}
		while(i <= mid){
			merged[k] = arr[i];
			k += 1;
			i += 1;
		}
		while(j <= ei){
			merged[k] = arr[j];
			k += 1;
			j += 1;
		}
		print(merged);
	}
	static void divide(int [] arr, int si, int ei){
		if(si >= ei) return;
		int mid = (si + ei) / 2;
		divide(arr, si, mid);
		divide(arr, mid+1, ei);
		conquer(arr, si, mid, ei);
	}
	public static void main(String [] args){
		int [] arr = {6, 2, 8, 5, 2, 8};
		int n = arr.length;
		divide(arr, 0, n-1);
	}
}