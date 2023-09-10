import java.util.Scanner;

public class N_Queen_Problem{
	
	static boolean issafe(int [][] chess, int row, int col) {
		
		for(int i = 0; i < chess.length; i++) {
			if((chess[i][col] == 1 && i != row) || (chess[row][i] == 1 && i != col)) return false;
		}
		
		for(int i = row, j = col; i < chess.length && j < chess.length; i++, j++) {
			if(chess[i][j] == 1) return false;
		}
		
		for(int i = row, j = col; i > -1 && j > -1; i--, j--) {
			if(chess[i][j] == 1) return false;
		}
		
		for(int i = row, j = col; i > -1 && j < chess.length; i--, j++) {
			if(chess[i][j] == 1) return false;
		}
		
		for(int i = row, j = col; i < chess.length && j > -1; i++, j--) {
			if(chess[i][j] == 1) return false;
		}
		
		return true;
		
	}
	
	static boolean nqueen(int [][] chess, int row) {
		
		if(row == chess.length) return true;
		for(int col = 0; col < chess.length; col++) {
			if(issafe(chess, row, col)) {
				chess[row][col] = 1;
				if(nqueen(chess, row+1)) return true;
				chess[row][col] = 0;
			}
		}
		return false;
		
	}
	
	public static void main(String [] args){
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [][] chess = new int[n][n];
		nqueen(chess, 0);
		scn.close();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(chess[i][j] == 1) System.out.print("Q ");
				else System.out.print("_ ");
			}
			System.out.println();
		}
		
	}
}