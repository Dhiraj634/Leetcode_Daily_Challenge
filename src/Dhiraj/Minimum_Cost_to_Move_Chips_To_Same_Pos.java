package Dhiraj;

public class Minimum_Cost_to_Move_Chips_To_Same_Pos {
	public int minCostToMoveChips(int[] position) {
		int even = 0;
		for(int num: position){
			if(num%2==0) even++;
		}
		return Math.min(position.length-even,even);
	}
}
