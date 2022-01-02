package January2022;

public class PairOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] fre = new int[60];
        for(int i=0;i<time.length;i++){
            time[i] = time[i] %60;
            fre[time[i]]++;
        }
        int count = 0;
        for(int t: time){
            fre[t]--;
            // Done this modulo because in the original array if something is divisible by 60 then there modulo will be 0
            int other = (60 - t) % 60;
            count+= Math.max(fre[other],0);
        }
        return count;
    }
}
