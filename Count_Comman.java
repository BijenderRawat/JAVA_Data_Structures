import java.util.Scanner;
import java.util.ArrayList;

public class Count_Comman {
	
	static int gcd(int a, int b) {
		if(a == 0) return b;
		return gcd(b%a, a);
	}
	
	static void countcomman(int g) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for(int i = 1; i <= Math.sqrt(g); i++) {
			if(g%i == 0) {
				if(g/i == i) {
					count += 1;
					list.add(i);
				}
				else {
					count += 2;
					list.add(i);
					list.add(g/i);
				}
			}
		}
		System.out.println(count);
		list.sort(null);
		System.out.println(list);
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		scn.close();
		
		int g = gcd(a, b);
		countcomman(g);
		
	}

}