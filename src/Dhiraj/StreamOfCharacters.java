package Dhiraj;

public class StreamOfCharacters {
	private Node root;
	private StringBuilder streamOfChar;
	public StreamOfCharacters(String[] words) {
		root = new Node('\0');
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
		if(index < 0) return;
		if(root.childNode[word.charAt(index)-'a'] == null){
			root.childNode[word.charAt(index)-'a'] = new Node(word.charAt(index));
		}
		insert(root.childNode[word.charAt(index)-'a'],word,index-1);
		if(index == 0){
			root.childNode[word.charAt(index)-'a'].isEnd = true;
		}
	}

	private boolean searchSuffix(String word, Node root, int charIndex){
		if(charIndex < 0) return false;
		if(root == null) return false;
		int index = word.charAt(charIndex) - 'a';
		if(root.childNode[index] != null){
			if(root.childNode[index].isEnd) return true;
			else{
				return searchSuffix(word,root.childNode[index],charIndex-1);
			}
		}else{
			return false;
		}

	}

	class Node{
		char value;
		Node[] childNode;
		boolean isEnd;
		public Node(char ch){
			this.value = ch;
			this.isEnd = false;
			childNode = new Node[26];
		}
	}
}
