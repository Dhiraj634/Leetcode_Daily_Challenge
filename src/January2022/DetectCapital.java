package January2022;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] ch = word.toCharArray();
        int cap=0, small=0;
        for(int i=1;i<word.length();i++){
            if(ch[i]>='A' && ch[i] <= 'Z'){
                cap++;
            }else{
                small++;
            }
        }
        if(small == word.length()-1) return true;
        else if(cap == word.length() -1){
            return  (ch[0]>='A' && ch[0] <= 'Z');

        }
        return false;
    }
}
