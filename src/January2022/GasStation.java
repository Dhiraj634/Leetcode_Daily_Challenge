package January2022;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] netCost = new int[gas.length];
        int[] cummNetCost = new int[gas.length];
        for(int i=0;i<gas.length;i++){
            netCost[i] = -cost[i] + gas[i];
        }
        cummNetCost[0] = netCost[0];
        for(int i=1;i<gas.length;i++){
            cummNetCost[i] = netCost[i] + cummNetCost[i-1];
        }

        int startIndex = -1, totalCost = 0;
        for(int i=0;i<len;i++){
            if(netCost[i] + totalCost >= 0){
                totalCost+=netCost[i];
                startIndex = startIndex == -1 ? i : startIndex;
            }else{
                startIndex = -1;
                totalCost = 0;
            }
        }
        if(startIndex == -1) return -1;
        else{
            int temp = (startIndex - 1 ) >=0 ? cummNetCost[startIndex-1] : 0;
            if(totalCost+temp >= 0){
                return startIndex;
            }else{
                return -1;
            }
        }
    }
}
