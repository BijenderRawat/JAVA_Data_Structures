public class Longest_Common_Subsequence{
	
	public static int lcs(String a, String b, int m, int n, int [][] dp){
		if(m == 0 || n == 0) return 0;
		if(dp[m][n] != -1) return dp[m][n];
		if(a.charAt(m-1) == b.charAt(n-1)) return dp[m][n] = lcs(a, b, m-1, n-1, dp)+1;
		return dp[m][n] = Math.max(lcs(a, b, m-1, n, dp), lcs(a, b, m, n-1, dp));
	}
	
	public static void main(String [] args){
		String a = "AEBC";
		String b = "ABE";
		
		int m = a.length();
		int n = b.length();
		
		int [][] dp = new int[m+1][n+1];
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				dp[i][j] = -1;
			}
		}
		
		System.out.println(lcs(a, b, m, n, dp));
	}
}