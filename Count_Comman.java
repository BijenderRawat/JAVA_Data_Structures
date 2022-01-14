import java.util.Scanner;

public class Count_Comman {
	
	static long gcd(long a, long b) {
		if(a == 0) return b;
		return gcd(b%a, a);
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter two numbers ");
		long a = scn.nextLong();
		long b = scn.nextLong();
		scn.close();
		
		long n = gcd(a, b);
		int c = 0;
		for(int i = 1; i <= Math.sqrt(n); i++) {
			if(n%i == 0) {
				if(n/i == i) c += 1;
				else c += 2;
			}
		}
		System.out.print("Total number of comman factors are " + c);
		
	}

}