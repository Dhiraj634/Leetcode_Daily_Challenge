package January2022;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1){
            if(flowerbed[0] == 0) return n <= 1;
            else{
                return n <= 0;
            }
        }
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] == 0) {
                if(i == 0){
                    if(flowerbed[i+1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }else if(i == flowerbed.length-1 ){
                    if(flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }else if(flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
