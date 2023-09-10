import java.util.List;
import java.util.ArrayList;

class TrieNode{
	TrieNode [] children;
	boolean isEndOfWord;
	int childNode;
	TrieNode(){
		children = new TrieNode[26];
		isEndOfWord = false;
		childNode = 0;
	}
}
public class Trie{
	public static List<Integer> result = new ArrayList<Integer>();
	public static void insert(TrieNode root, String key){
		TrieNode current = root;
		for(int i = 0; i < key.length(); i++){
			char ch = key.charAt(i);
			if(current.children[ch-'a'] == null){
				TrieNode newnode = new TrieNode();
				current.children[ch-'a'] = newnode;
			}
			current = current.children[ch-'a'];
			current.childNode = current.childNode+1;
		}
		current.isEndOfWord = true;
	}
	public static boolean search(TrieNode root, String key){
		TrieNode current = root;
		for(int i = 0; i < key.length(); i++){
			char ch = key.charAt(i);
			if(current.children[ch-'a'] == null) return false;
			current = current.children[ch-'a'];
		}
		return current.isEndOfWord;
	}
	public static void searchForPattern(TrieNode root, String key){
		TrieNode current = root;
		for(int i = 0; i < key.length(); i++){
			char ch = key.charAt(i);
			if(current.children[ch-'a'] == null){
				result.add(0);
				return;
			}
			current = current.children[ch-'a'];
		}
		result.add(current.childNode);
	}
	public static void main(String [] args){
		TrieNode root = new TrieNode();
		insert(root, "ed");
		insert(root, "eddie");
		insert(root, "edward");
		searchForPattern(root, "ed");
		insert(root, "edwina");
		searchForPattern(root, "edw");
		searchForPattern(root, "a");
		for(int l : result) System.out.print(l + " ");
	}
}