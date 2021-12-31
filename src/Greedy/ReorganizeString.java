package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] fre = new int[26];
        int max = -1;
        for(char ch: s.toCharArray()){
            fre[ch-'a']++;
            max = Math.max(max, fre[ch-'a']);
        }
        if(max > (s.length()+1) / 2) return "";
        // int[0] represents the character and int[1] represents the frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i=0;i<26;i++){
            if(fre[i] > 0) pq.add(new int[]{i, fre[i]});
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            ArrayList<int[]> tempList = new ArrayList<>();
            // This while loop can be replaced by an If statement since the loop will run atmost 1 time
            // because there can be only one character that can match the end of the last character of "sb"
            // and that we are taking out
            while(sb.length() > 0  && pq.size() > 0 &&  sb.charAt(sb.length()-1) - 'a' == pq.peek()[0]){
                tempList.add(pq.poll());
            }
            if(pq.size() == 0) return "";
            int[] node = pq.poll();
            sb.append((char)(node[0]+'a'));
            node[1]--;
            if(node[1] > 0) tempList.add(node);
            pq.addAll(tempList);

        }
        return sb.toString();
    }
}
