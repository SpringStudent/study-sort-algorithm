package bublesort;

import common.ArrayUtils;

public class BubleSort {

	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.generateArr(10);
		ArrayUtils.printArr(arr);
		System.out.println();
		bubleSort(arr);
		ArrayUtils.printArr(arr);
	}
	
	public static void bubleSort(int[] arr){
		int n = arr.length;
		for(int i = 0;i<n-1;i++){
			for(int j = 0;j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
