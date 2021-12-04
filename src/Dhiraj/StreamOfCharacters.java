package Dhiraj;

public class StreamOfCharacters {
	private Node root;
	private StringBuilder streamOfChar;
	public StreamOfCharacters(String[] words) {
		root = new Node();
		streamOfChar = new StringBuilder();
		for(String word: words){
			insert(root,word,word.length()-1);
		}
	}
	public boolean query(char letter) {
		streamOfChar.append(letter);
		return searchSuffix(streamOfChar.toString(),root,streamOfChar.length()-1);
	}

	private void insert(Node root, String word, int index){
		while(index >= 0){
			if(root.childNode[word.charAt(index)-'a'] == null){
				root.childNode[word.charAt(index)-'a'] = new Node();
			}
			root = root.childNode[word.charAt(index)-'a'];
			index--;
		}
		root.isEnd = true;
	}

	private boolean searchSuffix(String word, Node root, int charIndex){
		while(charIndex>=0){
			root = root.childNode[word.charAt(charIndex)-'a'];
			if(root==null) break;
			if(root.isEnd) return true;
			charIndex--;
		}
		return false;

	}

	class Node{
		Node[] childNode;
		boolean isEnd;
		public Node(){
			this.isEnd = false;
			childNode = new Node[26];
		}
	}
}
