package Dhiraj;

public class NumberComplement {
	public int findComplement(int num) {
		int complementNum = 0,pow=1;
		while(num>0){
			complementNum+=pow*((num & 1)^1);
			pow=pow << 1;
			num = num >> 1;
		}
		return complementNum;
	}
}
