package January2022;

public class StringToInteger {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        boolean isPositive = true;
        int index = 0;
        while(index < s.length() && s.charAt(index)==' ')index++;
        if(s.length() == index) return 0;
        if(s.charAt(index) == '-')
        {
            isPositive = false;index++;
        }
        else if(s.charAt(index) == '+')
        {
            isPositive = true;index++;
        }
        else{
            isPositive = true;
        }
        long value = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){

            if(isPositive){
                value = value * 10 + (s.charAt(index) - '0');
                value = Math.min(value, Integer.MAX_VALUE);
            }else{
                value = value * 10 - (s.charAt(index) - '0');
                value = Math.max(value, Integer.MIN_VALUE);
            }
            index++;
        }
        return (int)value;
    }
}
