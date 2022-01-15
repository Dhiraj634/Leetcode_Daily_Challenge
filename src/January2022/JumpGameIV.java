package January2022;

import java.util.*;

public class JumpGameIV {
    HashMap<Integer, ArrayList<Integer>> indexMap = new HashMap<>();
    public int minJumps(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            indexMap.putIfAbsent(arr[i], new ArrayList<>());
            indexMap.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] added = new boolean[arr.length];
        added[0] = true;
        int step = 0;
        while(queue.size() > 0){
            Queue<Integer> next = new LinkedList<>();

            while(queue.size() > 0){
                int index = queue.poll();
                if(index == arr.length -1) return step;

                for(int sameIndex : indexMap.get(arr[index])){
                    if(!added[sameIndex]){
                        next.add(sameIndex);
                        added[sameIndex] = true;
                    }
                }
                indexMap.get(arr[index]).clear();
                if( index > 0 && !added[index -1]){
                    next.add(index-1);
                    added[index-1]= true;
                }
                if( index < arr.length-1 && !added[index+1]){
                    next.add(index+1);
                    added[index+1]= true;
                }
            }
            queue = next;
            step++;
        }
        return step;

    }

}
