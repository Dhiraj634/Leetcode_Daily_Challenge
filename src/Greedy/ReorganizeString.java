package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] fre = new int[26];
        for(char ch: s.toCharArray()){
            fre[ch-'a']++;
        }
        // int[0] represents the character and int[1] represents the frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i=0;i<26;i++){
            if(fre[i] > 0) pq.add(new int[]{i, fre[i]});
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            ArrayList<int[]> tempList = new ArrayList<>();
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
