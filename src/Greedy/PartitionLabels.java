package Greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] lastIndex = new int[26];
        int index = 0;
        for(char ch: s.toCharArray()){
            lastIndex[ch - 'a'] = index++;
        }
        index = 0;
        while(index < s.length()){
            int end = lastIndex[s.charAt(index)-'a'];
            int start = index;
            while(index<=end){
                end = Math.max(end,lastIndex[s.charAt(index) - 'a']);
                index++;
            }
            ans.add(end - start + 1);
        }
        return ans;
    }
}
