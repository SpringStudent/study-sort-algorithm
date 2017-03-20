package shellsort;

import common.ArrayUtils;

public class ShellSort {

	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.generateArr(10);
		ArrayUtils.printArr(arr);
		System.out.println();
		shellSort(arr);
		ArrayUtils.printArr(arr);
	}

	/**
	 * 希尔排序
	 * 
	 * @author 周宁
	 * @date 2017年3月10日
	 * @param
	 * @return
	 * @throws
	 */

	public static void shellSort(int[] arr) {
		int length = arr.length;
		int gap = length / 2;
		while (gap >= 1) {
			for(int i = gap;i<length;i++){
				int temp = arr[i];
				int j =0;
				for(j =i-gap;j>=0&& temp < arr[j];j = j-gap){
					arr[j + gap] = arr[j];
				}
				arr[j+gap] = temp;
				
			}
			gap = gap/2;
		}
	}
}
