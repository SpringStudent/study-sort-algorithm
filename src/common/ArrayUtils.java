package common;

import java.util.Random;

public final class ArrayUtils {

	/**
	 * 生成一个长度为length的数组
	 * @author 周宁
	 * @date 2017年3月9日
	 * @param length
	 * @return
	 * @throws Exception
	 */
	public static int[] generateArr(int length) throws Exception{
		if(length<=0){
			throw new Exception("数组长度不能小于等于0");
		}
		int[] arr = new int[length];
		Random random = new Random();
		for(int i = 0;i<length;i++){
			arr[i] = random.nextInt(100);
		}
		return arr;
	}
	
	/**
	 * 打印数组元素到控制台
	 * @author 周宁
	 * @date 2017年3月9日
	 * @param arr
	 * @return
	 * @throws
	 */
	public static void printArr(int[] arr){
		int length = arr.length;
		for(int i = 0;i<length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
