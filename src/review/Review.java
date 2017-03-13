package review;

import common.ArrayUtils;

public class Review {

	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.generateArr(10);
		ArrayUtils.printArr(arr);
		System.out.println();
		insertSort(arr);
		ArrayUtils.printArr(arr);
		selectSort(arr);
		ArrayUtils.printArr(arr);
	}

	private static void selectSort(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++){
			int minIndex = i;
			for(int j=i+1;j<length;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}
			//½»»»Î»ÖÃ
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	private static void insertSort(int[] arr) {
		int length = arr.length;
		int i,j,k;
		for (i = 1; i < length; i++) {
			for (j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					break;
				}
			}
			if (j != i - 1) {
				int temp = arr[i];
				for (k = i - 1; k > j; k--) {
					arr[k + 1] = arr[k];
				}
				arr[k+1] = temp;
			}
		}
	}
}
