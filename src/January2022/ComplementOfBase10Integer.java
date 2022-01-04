package January2022;

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        if(n == 0) return n ^ 1;
        int newNum = n;
        int temp = 1;
        while(temp<=n){
            newNum = newNum ^ temp;
            temp<<=1;
        }
        return newNum;

    }
    /**
     *
     * public int bitwiseComplement(int n) {
     *   int mask=1;
     *   while(mask<n) mask=(mask<<1)+1;
     *   return mask^n;
     * }
     *
     * */


}
