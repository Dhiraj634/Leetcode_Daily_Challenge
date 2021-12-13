package Dhiraj;

public class ConsecutiveCharacters {
	public int maxPower(String s) {
		char lastChar = '\0';
		int power = 0, count=0;
		for(char ch: s.toCharArray()){
			if(lastChar != ch){
				count = 0;
			}
			lastChar = ch;
			count++;
			power = Math.max(power,count);
		}
		return power;
	}
}
