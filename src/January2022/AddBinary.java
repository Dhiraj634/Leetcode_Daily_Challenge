package January2022;

public class AddBinary {
    public String addBinary(String a, String b) {
        int len1 = a.length()-1;
        int len2 = b.length()-1;
        int carry = 0;
        StringBuilder sb= new StringBuilder();
        while(len1 >=0 && len2 >=0){
            int val = (a.charAt(len1--) -'0') + (b.charAt(len2--) - '0') + carry;
            /**
             * Below lines can be replaced by
             * sb.append(val%2);
             * carry = val /2;
             * */
            if(val == 1 || val == 3) sb.append(1);
            else sb.append(0);
            if(val == 3 || val == 2)
                carry = 1;
            else carry = 0;

        }
        while(len1 >= 0){
            int val = (a.charAt(len1--)  - '0') + carry;
            /**
             * Below lines can be replaced by
             * sb.append(val%2);
             * carry = val /2;
             * */
            if(val == 0 || val == 1){sb.append(val);carry =0;}
            else {
                sb.append(0);
                carry = 1;
            }
        }
        while(len2 >= 0){
            int val = (b.charAt(len2--)  - '0') + carry;
            /**
             * Below lines can be replaced by
             * sb.append(val%2);
             * carry = val /2;
             * */
            if(val == 0 || val == 1){sb.append(val);carry =0;}
            else {
                sb.append(0);
                carry = 1;
            }
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();


    }
}
