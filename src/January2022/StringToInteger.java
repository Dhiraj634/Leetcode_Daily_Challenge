package January2022;

public class StringToInteger {
    public int myAtoi(String s) {
        // If length == 0 return 0
        if(s.length() == 0) return 0;
        int index = 0;

        // Checking for whitespaces
        while(index < s.length() && s.charAt(index)==' ')index++;
        if(s.length() == index) return 0;

        // Checking for positive or negative number
        boolean isPositive = true;
        if(s.charAt(index) == '-')
        {
            isPositive = false;index++;
        }
        else if(s.charAt(index) == '+')
        {
           index++;
        }

        //Getting the content of the string
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
