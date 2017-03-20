package review;

import common.ArrayUtils;

public class Review {

	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.generateArr(10);
		ArrayUtils.printArr(arr);
		System.out.println();
		insertSort(arr);
		ArrayUtils.printArr(arr);
		System.out.println();
		selectSort(arr);
		ArrayUtils.printArr(arr);
		System.out.println();
		mergeSort(arr, 0, arr.length - 1);
		ArrayUtils.printArr(arr);
		System.out.println();
		quickSort(arr, 0, arr.length - 1);
		ArrayUtils.printArr(arr);
	}

	private static void selectSort(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// 交换位置
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	private static void insertSort(int[] arr) {
		int length = arr.length;
		int i, j, k;
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
				arr[k + 1] = temp;
			}
		}
	}

	public static void mergeSort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			sort(arr, low, mid, high);
		}
	}

	private static void sort(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= high) {
			temp[k++] = arr[j++];
		}

		for (int t = 0; t < temp.length; t++) {
			arr[low++] = temp[t];
		}
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int division = partition(arr, low, high);
			quickSort(arr, low, division - 1);
			quickSort(arr, division + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int base = arr[low];
		while (low < high) {
			while (arr[high] >= base && high >low) {
				high--;
			}
			arr[high] = base;
			while (arr[low] <= base && high >low) {
				low++;
			}
			arr[low] = base;
		}
		arr[low] = base;
		return low;
	}
}
