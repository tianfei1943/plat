package com.tecpie.plat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(5));
	}
	
	public static int count(int m){
		int amount = 0;
		for(int i=1;i<=m;i++){
			if(i%2==0){
				amount -= i;
			}else{
				amount += i;
			}
		}
		//1-2+3-4+5
		return amount;
	}

}
