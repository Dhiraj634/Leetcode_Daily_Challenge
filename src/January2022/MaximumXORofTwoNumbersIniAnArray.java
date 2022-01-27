package January2022;

public class MaximumXORofTwoNumbersIniAnArray {
    public int findMaximumXOR(int[] nums) {
        TrieNode head = new TrieNode();
        String[] binArray = new String[nums.length];
        int m=0;
        for(int num : nums){
            String str = Integer.toBinaryString(num);
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=(32-str.length());i++){
                sb.append(0);
            }
            sb.append(str);
            binArray[m++] = sb.toString();
            sb.delete(0, sb.length());
        }
        for(String str: binArray){
            addToTrie(head, str);
        }
        int max = -1;
        for(int i=0;i<nums.length;i++){
            int num1 = getMax(head,binArray[i]);
            int num2 =nums[i];
            max = Math.max(max,num1^num2);
        }
        return max;


    }
    private int getMax(TrieNode head, String str){

        int bit = 0;
        StringBuilder sb = new StringBuilder();
        while(bit<=31){
            int bitRequired = str.charAt(bit) - '0';
            bitRequired^=1;
            if(head.next[bitRequired]!=null){
                sb.append(bitRequired);
                head = head.next[bitRequired];
            }else{
                sb.append(bitRequired^1);
                head = head.next[bitRequired^1];
            }
            bit++;
        }

        return Integer.parseInt(sb.toString(),2);
    }
    void addToTrie(TrieNode head, String bin){
        int bit = 0;
        while(bit<=31){
            int currBit = bin.charAt(bit) - '0';
            if(head.next[currBit] == null){
                head.next[currBit] = new TrieNode();
            }
            head = head.next[currBit];
            bit++;
        }
    }


    private class TrieNode {
        TrieNode[] next;
        TrieNode(){
            this.next = new TrieNode[2];
        }
    }
}
