package test;

import common.ArrayUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.generateArr(10);
		ArrayUtils.printArr(arr);
		System.out.println();
		quickSort(arr);
		ArrayUtils.printArr(arr);
		
		System.out.println();
		mergeSort(arr);
		ArrayUtils.printArr(arr);
		
		System.out.println();
		selectSort(arr);
		ArrayUtils.printArr(arr);
		
		System.out.println();
		insertSort(arr);
		ArrayUtils.printArr(arr);
		
		System.out.println();
		bubleSort(arr);
		ArrayUtils.printArr(arr);
		System.out.println();
		int[] arr1 = new int[]{1,2,4,5,6,7};
		System.out.println(binSearch(arr1,11));
	}
	
	/**
	 * 快速排序的思想:通过一轮排序将序列分割为两个部分，其中一部分大于基数，另一部分小于基数,继续对长度较短的
	 * 子序列进行分割最终达到序列有序,由于分割的两部分不需要比较所以减少了时间复杂度
	 * @author 周宁
	 * @date 2017年3月20日
	 * @param 
	 * @return 
	 * @throws
	 */
	public static void quickSort(int[] arr){
		if(arr==null||arr.length==0){
			throw new NullPointerException("数组为空");
		}
		quickSort(arr,0,arr.length-1);
	}

	private static void quickSort(int[] arr, int i, int length) {
		if(i<length){
			int division = partition(arr,i,length);
			quickSort(arr,i,division-1);
			quickSort(arr,division+1,length);
		}
		
	}

	private static int partition(int[] arr, int i, int length) {
		int base = arr[i];
		while(i<length){
			while(arr[length]>=base&&i<length){
				length--;
			}
			arr[i] =arr[length];
			while(arr[i]<=base&&i<length){
				i++;
			}
			arr[length] = arr[i];
		}
		arr[length] = base;
		return i;
	}
	
	/**
	 * 采用的是分治思想：将有序的子序列合并得到有序的序列。
	 * @author 周宁
	 * @date 2017年3月20日
	 * @param 
	 * @return 
	 * @throws
	 */
	public static void mergeSort(int[] arr){
		if(arr==null||arr.length==0){
			throw new NullPointerException("数组为空");
		}
		mergeSort(arr,0,arr.length-1);
	}

	private static void mergeSort(int[] arr, int i, int j) {
		int mid = (i+j)/2;
		if(i<j){
			mergeSort(arr,i,mid);
			mergeSort(arr,mid+1,j);
			merge(arr,i,mid,j);
		}
	}

	/**
	 * 归并排序采用分治思想，将已有序的子序列合并得到完全有序的序列。
	 * @author 周宁
	 * @date 2017年3月20日
	 * @param 
	 * @return 
	 * @throws
	 */
	private static void merge(int[] arr, int i, int mid, int j) {
		int[] temp = new int[j-i+1];
		int k = 0;
		int left = i;// 左指针  
        int right = mid + 1;// 右指针  
		while(left<=mid&&right<=j){
			if(arr[i]<arr[j]){
				temp[k++] = arr[left++];
			}else{
				temp[k++] = arr[right++];
			}
		}
		while(left<=mid){
			temp[k++] = arr[left++];
		}
		while(right<=j){
			temp[k++] = arr[right++];
		}
		for(int n = 0;n<temp.length;n++){
			arr[i+n] = temp[n];
		}
	}
	
	/**
	 * 每次从n-i+1个元素中选择最小的元素作为有序序列的第i个元素
	 * @author 周宁
	 * @date 2017年3月20日
	 * @param 
	 * @return 
	 * @throws
	 */
	public static void selectSort(int[] arr){
		int n = arr.length;
		for(int i = 0;i<n;i++){
			int minIndex = i;
			for(int j= i+1;j<n;j++){
				if(arr[j]<arr[i]){
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	/**
	 * 每次将一个待排序的记录插入到已经有序的记录中
	 * @author 周宁
	 * @date 2017年3月20日
	 * @param 
	 * @return 
	 * @throws
	 */
	public static void insertSort(int[] arr){
		int n = arr.length-1;
		int i,j,k;
		for(i = 1;i<n;i++){
			for(j = i-1;j>0;j--){
				if(arr[i]>arr[j]){
					break;
				}
			}
			if(j!=i-1){
				for(k = i-1;k>j;k++){
					arr[k+1] = arr[k];
				}
				arr[k+1] = arr[i];
			}
		}
	}
	
	/**
	 * 冒泡排序的思想:重复的走过待排序序列，一次比较两个元素,如果他们的顺序错误则就把他们交换过来。
	 * @author 周宁
	 * @date 2017年3月20日
	 * @param 
	 * @return 
	 * @throws
	 */
	public static void bubleSort(int[] arr){
		int n =arr.length-1;
		for(int i = 0;i<n;i++){
			for(int j = n-i+1;j<n;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 二分查找法
	 * @author 周宁
	 * @date 2017年3月20日
	 * @param 
	 * @return 
	 * @throws
	 */
	public static int binSearch(int[] arr,int num){
		return binSearch(arr,0,arr.length-1,num);
	}
	
	public static int binSearch(int[] arr,int low,int high,int num){
		int mid = (low+high)/2;
		if(low>high){
			return -1;
		}
		if(arr[mid] ==num){
			return mid;
		}else{
			if(arr[mid]>num){
				return binSearch(arr,low,mid-1,num);
			}else{
				return binSearch(arr,mid+1,high,num);
			}
		}
	}
}
