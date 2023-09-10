public class SearchInRotatedArray {
    public static void solve(int[] a, int key) {
        int l = 0, h = a.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (a[mid] == key) {
                System.out.println("Element Present at " + (mid+1) + " position");
                return;
            }
            if (a[l] < a[mid]) {
                if (key >= a[l] && key < a[mid])
                    h = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (key >= a[mid + 1] && key <= a[h])
                    l = mid + 1;
                else
                    h = mid - 1;
            }
        }
        System.out.println("Element Not Present");
    }

    public static void main(String [] args){
        int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        solve(a, 12);
    }
}