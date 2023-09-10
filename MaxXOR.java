class TrieNode{
	TrieNode zero, one; 
	TrieNode(){
		zero = null;
		one = null;
	}

	public void insert(TrieNode root, int n){
		TrieNode currNode = root;
		for(int i = 31; i >= 0; i--){
			int bit = (n >> i) & 1;
			if(bit == 0){
				if(currNode.zero == null){
					TrieNode newnode = new TrieNode();
					currNode.zero = newnode;
				}
				currNode = currNode.zero;
			}else{
				if(currNode.one == null){
					TrieNode newnode = new TrieNode();
					currNode.one = newnode;
				}
				currNode = currNode.one;
			}
		}
	}

	public int findMax(TrieNode root, int n){
		TrieNode currNode = root;
		int ans = 0;
		for(int i = 31; i >= 0; i--){
			int bit = (n >> i) & 1;
			if(bit == 0){
				if(currNode.one != null){
					ans += (1 << i);
					currNode = currNode.one;
				}else{
					currNode = currNode.zero;
				}
			}else{
				if(currNode.zero != null){
					ans += (1 << i);
					currNode = currNode.zero;
				}else{
					currNode = currNode.one;
				}
			}
		}
		return ans;
	}
}
public class MaxXOR{
	public static void main(String [] args){
		TrieNode root = new TrieNode();
		int [] array = {8, 5, 4, 9, 1};
		for(int i : array) root.insert(root, i);
		int ans = 0;
		for(int i : array) ans = Math.max(ans, findMax(root, i));
		System.out.println(ans);
	}
}