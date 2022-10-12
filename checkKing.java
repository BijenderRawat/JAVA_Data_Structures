public class checkKing {
	public static boolean checkForRook(char [][] chessBoard, int i, int j){
        for(int a = j-1; a >= 0; a--){
			if(chessBoard[i][a] == 'r' || chessBoard[i][a] == 'q') return false;
			if(chessBoard[i][a] != 'o') break;
		}
        for(int a = j+1; a < 8; a++){
			if(chessBoard[i][a] == 'r' || chessBoard[i][a] == 'q') return false;
			if(chessBoard[i][a] != 'o') break;
		}
        for(int a = i-1; a >= 0; a--){
			if(chessBoard[a][j] == 'r' || chessBoard[a][j] == 'q') return false;
			if(chessBoard[a][j] != 'o') break;
		}
        for(int a = i+1; a < 8; a++){
			if(chessBoard[a][j] == 'r' || chessBoard[a][j] == 'q') return false;
			if(chessBoard[a][j] != 'o') break;
		}
        return true;
    }
    public static boolean checkForBishop(char [][] chessBoard, int i, int j){
		if(i == j){
			for(int a = i-1, b = j-1; a >= 0 && b >= 0; a--, b--){
				if(chessBoard[a][b] == 'b' || chessBoard[a][b] == 'q') return false;
				if(chessBoard[a][b] != 'o') break;
			}
			for(int a = i+1, b = j+1; a < 8 && b < 8; a++, b++){
				if(chessBoard[a][b] == 'b' || chessBoard[a][b] == 'q') return false;
				if(chessBoard[a][b] != 'o') break;
			}
			for(int a = i+1, b = j-1; a < 8 && b >= 0; a++, b--){
				if(chessBoard[a][b] == 'b' || chessBoard[a][b] == 'q') return false;
				if(chessBoard[a][b] != 'o') break;
			}
			for(int a = i-1, b = j+1; a >= 0 && b < 8; a--, b++){
				if(chessBoard[a][b] == 'b' || chessBoard[a][b] == 'q') return false;
				if(chessBoard[a][b] != 'o') break;
			}
		}
		else{
			for(int a = i+1, b = j+1; a < 8 && b < 8; a++, b++){
				if(chessBoard[a][b] == 'b' || chessBoard[a][b] == 'q') return false;
				if(chessBoard[a][b] != 'o') break;
			}
			for(int a = i-1, b = j-1; a >= 0 && b >= 0; a--, b--){
				if(chessBoard[a][b] == 'b' || chessBoard[a][b] == 'q') return false;
				if(chessBoard[a][b] != 'o') break;
			}
			for(int a = i-1, b = j+1; a >= 0 && b < 8; a--, b++){
				if(chessBoard[a][b] == 'b' || chessBoard[a][b] == 'q') return false;
				if(chessBoard[a][b] != 'o') break;
			}
			for(int a = i+1, b = j-1; a < 8 && b >= 0; a++, b--){
				if(chessBoard[a][b] == 'b' || chessBoard[a][b] == 'q') return false;
				if(chessBoard[a][b] != 'o') break;
			}
		}
        return true;
    }
    public static boolean checkForKnight(char [][] chessBoard, int i, int j){
		if(i >= 2 && i <= 5 && j >= 2 && j <= 5) if(chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i+1][j-2] == 'k') return false;
		if(i == 0){
            if(j >= 2 && j <= 5) if(chessBoard[i+2][j-1] == 'k' || chessBoard[i+2][j+1] == 'k' || chessBoard[i+1][j+2] == 'k' || chessBoard[i+1][j-2] == 'k') return false;
            else if(j == 0 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(j == 1 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(j == 6 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
            else if(j == 7 && (chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
        }
		if(i == 1){
            if(j >= 2 && j <= 5) if(chessBoard[i+2][j-1] == 'k' || chessBoard[i+2][j+1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i+1][j-2] == 'k') return false;
            else if(j == 0 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+1][j+2] == 'k' || chessBoard[i-1][j+2] == 'k')) return false;
            else if(j == 1 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j+2] == 'k' || chessBoard[i-1][j+2] == 'k')) return false;
            else if(j == 6 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j-2] == 'k' || chessBoard[i-1][j-2] == 'k')) return false;
            else if(j == 7 && (chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j-2] == 'k' || chessBoard[i-1][j-2] == 'k')) return false;
        }
		if(i == 6){
            if(j >= 2 && j <= 5) if(chessBoard[i-2][j-1] == 'k' || chessBoard[i-2][j+1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i+1][j-2] == 'k') return false;
            else if(j == 0 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(j == 1 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(j == 6 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
            else if(j == 7 && (chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
        }
        if(i == 7){
            if(j >= 2 && j <= 5) if(chessBoard[i-2][j-1] == 'k' || chessBoard[i-2][j+1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i-1][j-2] == 'k') return false;
            else if(j == 0 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-1][j+2] == 'k')) return false;
            else if(j == 1 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j+2] == 'k')) return false;
            else if(j == 6 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k')) return false;
            else if(j == 7 && (chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k')) return false;
        }
		if(j == 0){
            if(i >= 2 && i <= 5) if(chessBoard[i+2][j-1] == 'k' || chessBoard[i+2][j+1] == 'k' || chessBoard[i-2][j+1] == 'k' || chessBoard[i+2][j+1] == 'k') return false;
            else if(i == 0 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(i == 1 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(i == 6 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i+1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(i == 7 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-1][j+2] == 'k')) return false;
        }
		if(j == 1){
            if(i >= 2 && i <= 5) if(chessBoard[i+1][j+2] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k') return false;
            else if(i == 0 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(i == 1 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(i == 6 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j+2] == 'k' || chessBoard[i+1][j+2] == 'k')) return false;
            else if(i == 7 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j+2] == 'k')) return false;
        }
		if(j == 6){
            if(i >= 2 && i <= 5) if(chessBoard[i+1][j-2] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k') return false;
            else if(i == 0 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
            else if(i == 1 && (chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
            else if(i == 6 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
            else if(i == 7 && (chessBoard[i-2][j+1] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k')) return false;
        }
		if(j == 7){
            if(i >= 2 && i <= 5) if(chessBoard[i+1][j-2] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i-2][j-1] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i+2][j+1] == 'k' || chessBoard[i+2][j-1] == 'k') return false;
            else if(i == 0 && (chessBoard[i+2][j-1] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
            else if(i == 1 && (chessBoard[i+1][j-2] == 'k' || chessBoard[i+2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k')) return false;
            else if(i == 6 && (chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k' || chessBoard[i+1][j-2] == 'k')) return false;
            else if(i == 7 && (chessBoard[i-2][j-1] == 'k' || chessBoard[i-1][j-2] == 'k')) return false;
        }
        return true;
    }
    public static boolean checkForPawn(char [][] chessBoard, int i, int j){ 
        if(i >= 1 && i <= 6 && j >= 1 && j <= 6) if(chessBoard[i-1][j-1] == 'p' || chessBoard[i-1][j+1] == 'p' || chessBoard[i+1][j-1] == 'p' || chessBoard[i+1][j+1] == 'p') return false;
        if(i == 0){
            if(j >= 1 && j <= 6) if(chessBoard[i+1][j-1] == 'p' || chessBoard[i+1][j+1] == 'p') return false;
            else if(j == 0 && chessBoard[i+1][j+1] == 'p') return false;
            else if(j == 7 && chessBoard[i+1][j-1] == 'p') return false;
        }
        if(i == 7){
            if(j >= 1 && j <= 6) if(chessBoard[i-1][j-1] == 'p' || chessBoard[i-1][j+1] == 'p') return false;
            else if(j == 0 && chessBoard[i-1][j+1] == 'p') return false;
            else if(j == 7 && chessBoard[i-1][j-1] == 'p') return false;
        }
        if(j == 0){
            if(i >= 1 && i <= 6) if(chessBoard[i+1][j+1] == 'p' || chessBoard[i-1][j+1] == 'p') return false;
            else if(i == 0 && chessBoard[i+1][j+1] == 'p') return false;
            else if(i == 7 && chessBoard[i-1][j+1] == 'p') return false;
        }
        if(j == 7){
            if(i >= 1 && i <= 6) if(chessBoard[i+1][j-1] == 'p' || chessBoard[i-1][j-1] == 'p') return false;
            else if(i == 0 && chessBoard[i+1][j-1] == 'p') return false;
            else if(i == 7 && chessBoard[i-1][j-1] == 'p') return false;
        }
        return true;
    }
    public static boolean isKingSafe(char [][] chessBoard){
        int i = 0, j = 0;
        for(int a = 0; a < 8; a++){
            for(int b = 0; b < 8; b++){
                if(chessBoard[a][b] == 'K'){
                    i = a;
                    j = b;
                    break;
                }
            }
        }
        if(checkForRook(chessBoard, i, j) && checkForBishop(chessBoard, i, j) && checkForKnight(chessBoard, i, j) && checkForPawn(chessBoard, i, j)) return true;
        return false;
    }
    public static void main(String args[]) {
        char [][] chessBoard = {
            {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
            {'p', 'p', 'p', 'o', 'p', 'p', 'p', 'p'},
            {'o', 'o', 'p', 'o', 'o', 'b', 'o', 'o'},
            {'o', 'o', 'K', 'k', 'o', 'o', 'o', 'o'}, 
            {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'}, 
            {'o', 'b', 'o', 'o', 'p', 'o', 'o', 'o'}, 
            {'p', 'o', 'p', 'p', 'p', 'b', 'p', 'p'}, 
            {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'}
        };
        System.out.print(isKingSafe(chessBoard) ? "King is safe" : "king is not safe");
    }
}