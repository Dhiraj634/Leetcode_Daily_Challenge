package January2022;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] str = s.split(" ");
        if(str.length!= pattern.length()) return false;
        for(int i=0;i<str.length;i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(str[i]))return false;
            }else{
                if(set.contains(str[i])) return false;
            }
            map.put(ch,str[i]);
            set.add(str[i]);

        }
        return true;
    }
}
