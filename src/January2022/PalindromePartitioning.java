package January2022;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> ans = new ArrayList<>();
    List<String> currList = new ArrayList<>();
    boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        isPalindrome = new boolean[s.length()][s.length()];
        for(int start = 0;start<s.length();start++){
            for(int end = start;end<s.length();end++){
                isPalindrome[start][end] = checkPalindrome(s,start,end);
            }
        }
        return partitionHelper(s, 0);
    }
    public List<List<String>> partitionHelper(String s, int start){
        if(s.length() == start ){
            ans.add(new ArrayList<>(currList));
            return ans;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=start;i<s.length();i++){
            sb.append(s.charAt(i));
            String temp = sb.toString();
            if(isPalindrome[start][i]){
                currList.add(temp);
                partitionHelper(s,i+1);
                currList.remove(currList.size()-1);
            }
        }
        return ans;
    }
    private boolean checkPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}

