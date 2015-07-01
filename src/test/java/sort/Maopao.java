package sort;


public class Maopao {

	public static void main(String[] args) {
		//Student[] arr = {new Student(1,"c",11),new Student(1,"b",0),new Student(1,"a",9)};
		int[] arr = {19,33,0,3234,77};  
		//maoPao(arr);
		quick_sort(arr, 0, arr.length-1);
		for(int i : arr){
			System.out.println(i);
		}
	}
	/**
	 * 冒泡排序法（自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒）--每一轮把最大的值放到下面
	 */
	public static void maoPao(int[] arr){
		
		int length = arr.length;
		for(int i=0;i<length;i++){
			for(int j=0;j<length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}
	/**
	 * 快速排序（挖坑填数+分治法）
	 * @param s
	 * @param l
	 * @param r
	 */
	public static void quick_sort(int s[],int l,int r){
		if(l < r){
			int i =l;
			int j = r;
			int x = s[l];
			while(i < j){
				while(i < j && s[j] >= x){// 从右向左找第一个小于x的数  
					j--;
				}
				if(i < j){
					s[i] = s[j];
					i++;
				}
				while(i<j && s[i] < x){// 从左向右找第一个大于等于x的数  
					i++;
				}
				if(i<j){
					s[j] = s[i];
					j--;
				}
			}
			s[i] = x;
			quick_sort(s,l,i-1);
			quick_sort(s,i+1,r);
		}
	}

}
