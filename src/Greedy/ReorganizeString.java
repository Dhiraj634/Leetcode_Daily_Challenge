package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] fre = new int[26];
        for(char ch: s.toCharArray()){
            fre[ch-'a']++;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.fre - a.fre);
        for(int i=0;i<26;i++){
            if(fre[i] > 0) pq.add(new Node((char)('a'+i),fre[i]));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            ArrayList<Node> tempList = new ArrayList<>();
            while(sb.length() > 0  && pq.size() > 0 &&  sb.charAt(sb.length()-1) == pq.peek().ch){
                tempList.add(pq.poll());
            }
            if(pq.size() == 0) return "";
            Node node = pq.poll();
            sb.append(node.ch);
            node.fre--;
            if(node.fre > 0) tempList.add(node);
            pq.addAll(tempList);

        }
        return sb.toString();

    }
    private class Node {
        int fre;
        char ch;
        Node(char _ch,int _fre){
            this.ch = _ch;
            this.fre = _fre;
        }
    }
}
