package January2022;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustOther = new int[n+1];
        int[] trustedBy = new int[n+1];
        for(int[] arr: trust){
            trustOther[arr[0]]++;
            trustedBy[arr[1]]++;
        }
        for(int i=1;i<n+1;i++){
            if(trustedBy[i] == n-1 && trustOther[i] == 0)
                return i;
        }
        return -1;
    }
}
