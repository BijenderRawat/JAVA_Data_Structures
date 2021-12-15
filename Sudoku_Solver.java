public class Sudoku_Solver{
	
	static boolean issafe(int [][] sudoku, int row, int col, int num) {
		
		for(int i = 0; i < sudoku.length; i++) {
			if(sudoku[i][col] == num || sudoku[row][i] == num) return false;
		}
		
		int sizeofblock = (int)Math.sqrt(sudoku.length);
		int rowstart = row - row % sizeofblock;
		int colstart = col - col % sizeofblock;
		
		for(int i = rowstart; i < rowstart+sizeofblock; i++) {
			for(int j = colstart; j < colstart+sizeofblock; j++) {
				if(sudoku[i][j] == num) return false;
			}
		}
		
		return true;
		
	}
	
	static boolean sudokusolver(int [][] sudoku, int n) {
		
		int row = 0, col = 0;
		boolean isempty = true;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(sudoku[i][j] == 0) {
					row = i;
					col = j;
					isempty = false;
					break;
				}
			}
			if(!isempty) break;
		}
		if(isempty) return true;
		
		for(int num = 1; num <= n; num++) {
			if(issafe(sudoku, row, col, num)) {
				sudoku[row][col] = num;
				if(sudokusolver(sudoku, n)) return true;
				else sudoku[row][col] = 0;
			}
		}
		return false;
		
	}
	
	public static void main(String [] args){
		
		int [][] sudoku = {
				{8, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 3, 6, 0, 0, 0, 0, 0},
				{0, 7, 0, 0, 9, 0, 2, 0, 0},
				{0, 5, 0, 0, 0, 7, 0, 0, 0}, 
				{0, 0, 0, 0, 4, 5, 7, 0, 0}, 
				{0, 0, 0, 1, 0, 0, 0, 3, 0},
				{0, 0, 1, 0, 0, 0, 0, 6, 8},
				{0, 0, 8, 5, 0, 0, 0, 1, 0},
				{0, 9, 0, 0, 0, 0, 4, 0, 0}
			};
		
		int n = sudoku.length;
		sudokusolver(sudoku, n);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}