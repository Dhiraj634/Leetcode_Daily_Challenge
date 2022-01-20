package January2022;

public class KokoEatsBananas {
    public int minEatingSpeed(int[] piles, int h) {
        long total =0;
        int max= -1;
        for(int pile :piles){
            total+=pile;
            max = Math.max(max,pile);
        }
        int upper = max;
        int lower = (int)((total-1)/h) + 1;
        while(lower <= upper){
            int mid = (lower + upper)/2;
            if(isPossible(mid,h,piles)){
                upper = mid-1;
            }else{
                lower=mid+1;
            }
        }
        return lower;
    }
    private boolean isPossible(int k, int h,int[] piles){
        int count = 0;
        for(int pile:piles){
            count += ((pile-1) / k) +1;
        }
        return count <= h;
    }
}
