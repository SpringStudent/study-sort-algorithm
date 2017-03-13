package insertionsort;

import common.ArrayUtils;

public class InsertionSort {

	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.generateArr(10);
		ArrayUtils.printArr(arr);
		System.out.println();
		insertionSort(arr);
		ArrayUtils.printArr(arr);
	}

	/**
	 * 插入排序
	 * @author 周宁
	 * @date 2017年3月9日
	 * @param
	 * @return
	 * @throws
	 */
	private static void insertionSort(int[] a) {
		int length = a.length;
		int i, j, k;
		for (i = 1; i < length; i++) {
			// 为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
			for (j = i - 1; j >= 0; j--) {
				if (a[j] < a[i]) {
					break;
				}
			}
			if (j != i - 1) {
				// 将比a[i]大的数据向后移
				int temp = a[i];
				for (k = i - 1; k > j; k--){
					a[k + 1] = a[k];
				}
				// 将a[i]放到正确位置上
				a[k + 1] = temp;
			}
		}
	}
}
