package January2022;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,HashSet<String>> map = new HashMap<>();
        HashMap<String,HashSet<Character>> strMap = new HashMap<>();
        String[] str = s.split(" ");
        if(str.length!= pattern.length()) return false;
        for(int i=0;i<str.length;i++){
            char ch= pattern.charAt(i);
            map.putIfAbsent(ch,new HashSet<>());
            strMap.putIfAbsent(str[i],new HashSet<>());
            map.get(ch).add(str[i]);
            strMap.get(str[i]).add(ch);
        }
        for(char ch: map.keySet()){
            if(map.get(ch).size() > 1) return false;
        }
        for(String str1: strMap.keySet()){
            if(strMap.get(str1).size() > 1) return false;
        }
        return true;
    }
}
