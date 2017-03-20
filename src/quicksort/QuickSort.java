package quicksort;

import common.ArrayUtils;

public class QuickSort {

	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.generateArr(15);
		ArrayUtils.printArr(arr);
		System.out.println();
		quickSort(arr);
		ArrayUtils.printArr(arr);
	}

	public static void quickSort(int[] arr) throws Exception {
		if (arr.length == 0 || arr == null) {
			throw new Exception("数组不能为空");
		}
		recursionQuickSort(arr, 0, arr.length - 1);
	}

	private static void recursionQuickSort(int[] arr, int low, int high) {
		if (low < high) {
			// 将数组拆分成两部分,左边部分小于基准数右边部分大于基准数
			int divison = partition(arr, low, high);
			recursionQuickSort(arr, low, divison - 1);
			recursionQuickSort(arr, divison + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int base = arr[low];
		while (low < high) {
			while (arr[high] >= base && high > low) {
				high--;
			}
			arr[low] = arr[high];
			while (arr[low] <= base && high > low) {
				low++;
			}
			arr[high] = arr[low];
		}
		// 必须要
		arr[low] = base;
		return low;
	}
}
