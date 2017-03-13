package selectsort;

import common.ArrayUtils;

public class SelectSort {

	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.generateArr(10);
		ArrayUtils.printArr(arr);
		System.out.println();
		selectSort(arr);
		ArrayUtils.printArr(arr);
	}

	/**
	 * 选择排序
	 * @author 周宁
	 * @date 2017年3月9日
	 * @param arr
	 * @return
	 * @throws
	 */
	public static void selectSort(int[] arr) {
		int length = arr.length;
		int i, j, nMinIndex;  
	    for (i = 0; i < length; i++)  
	    {  
	        nMinIndex = i; //找最小元素的位置  
	        for (j = i + 1; j < length; j++){  
	            if (arr[j] < arr[nMinIndex]){  
	                nMinIndex = j;  
	            }
	        } 
	        swap(arr,i,nMinIndex); //将这个元素放到无序区的开头  
	    }  
	}
	
	/**
	 * 使用位运算交换两个元素
	 * @author 周宁
	 * @date 2017年3月9日
	 * @param a
	 * @param b
	 * @return
	 * @throws
	 */
	private static void swap(int[] arr,int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
