import java.util.Scanner;
class SelectMaximum
{
    public static int min = Integer.MAX_VALUE;
    public static int[] minleft(int [] A, int N){
        int [] result = new int[N];
        for(int i = 0; i < N; i++){
            if(i == 0){
                result[i] = 0;
                continue;
            }
            min = Math.min(min, A[i-1]);
            result[i] = min;
        }
        min = Integer.MAX_VALUE;
        return result;
    }
    public static int[] minright(int [] A, int N){
        int [] result = new int[N];
        for(int i = N-1; i >= 0; i--){
            if(i == N-1){
                result[i] = 0;
                continue;
            }
            min = Math.min(min, A[i+1]);
            result[i] = min;
        }
        return result;
    }
    public static int[] findDifferenceArray(int N, int A[])
    {
        int [] result = new int[N];
        int [] minleftarray = minleft(A, N);
        int [] minrightarray = minright(A, N);
        for(int i = 0; i < N; i++) result[i] = minleftarray[i] - minrightarray[i];
        return result;
    }
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int [] array = new int[N];
        for(int i = 0; i < N; i++) array[i] = scn.nextInt();
        array = findDifferenceArray(N, array);
        for(int i : array) System.out.print(i + " ");
    }
}