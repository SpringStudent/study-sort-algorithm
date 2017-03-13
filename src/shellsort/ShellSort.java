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
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < length; j = j + gap) {
					if (arr[j] < arr[j - gap]) {
						int temp = arr[j];
						int k = j - gap;
						while (k >= 0 && arr[k] > temp) {
							arr[k + gap] = arr[k];
							k -= gap;
						}
						arr[k + gap] = temp;
					}
				}
			}
			gap = gap / 2;
		}
	}
}
