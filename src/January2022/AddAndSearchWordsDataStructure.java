package January2022;

public class AddAndSearchWordsDataStructure {
    TrieNode head;

    public AddAndSearchWordsDataStructure() {
        head = new TrieNode('\0');
        head.isEnd = true;
    }

    public void addWord(String word) {
        TrieNode temp = head;
        for(int i = 0 ; i< word.length();i++){
            int index = word.charAt(i) - 'a';
            if(temp.nextNode[index]==null){
                temp.nextNode[index] = new TrieNode(word.charAt(i));
            }
            temp = temp.nextNode[index];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {

        return searchUtil(head, word, 0);
    }
    boolean searchUtil(TrieNode head, String word, int index){
        if(head == null) return false;
        if(index == word.length()) return head.isEnd;
        for(int i= index; i< word.length() ; i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(int j=0;j<26;j++){

                    if(searchUtil(head.nextNode[j], word, i+1))
                        return true;
                }
                return false;

            }else if(head.nextNode[ch - 'a'] == null){
                return false;

            }else{
                head = head.nextNode[ch - 'a'];
            }
        }
        return head.isEnd;
    }

    private class TrieNode {
        TrieNode[] nextNode;
        char ch;
        boolean isEnd;
        TrieNode(char ch){
            this.ch = ch;
            this.isEnd = false;
            this.nextNode = new TrieNode[26];
        }
    }
}
