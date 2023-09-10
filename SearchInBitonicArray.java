// bitonic array wo array hota h jo aadha increasingly sorted hota and aadha decreasingly sorted.
// is type k array m koi bhi number search karne se pehle hume is array ka peek element pta hona chahiye
// peek element wo element hoga jisse left k saare element usse chote ho or right k saare element usse bade
// peek element pta karne k baad hum 2 baar binary search use karenge
// ek baar left side k array pr jo increading way m sorted h
// or doosri baar right side waale array p jo decreasing way m sorted h

public class SearchInBitonicArray {
    public static int solve(int[] A, int B) {
        int n = A.length;
        if (n == 1) {
            if (A[0] == B)
                return 0;
            else
                return -1;
        }
        int s = 0;
        int e = n - 1;
        int peek = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid > 0 && mid < n - 1) {
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    peek = mid;
                    break;
                }
            } else if (mid == 0) {
                if (A[mid] > A[mid + 1]) {
                    peek = mid;
                    break;
                }
            } else if (mid == n - 1) {
                if (A[mid] > A[mid - 1]) {
                    peek = mid;
                    break;
                }
            }
            if (A[mid + 1] > A[mid])
                s = mid + 1;
            else if (A[mid - 1] > A[mid])
                e = mid - 1;
        }

        s = 0;
        e = peek;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (A[mid] == B)
                return mid;
            if (A[mid] > B)
                e = mid - 1;
            else
                s = mid + 1;
        }

        s = peek + 1;
        e = n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (A[mid] == B)
                return mid;
            if (A[mid] < B)
                e = mid - 1;
            else
                s = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };
        System.out.print(solve(A, 12));
    }
}