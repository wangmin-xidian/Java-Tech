package com.ali.interview;
/**
 * 
 * @author Wangmin
 * @Date 2018/12/05
 * @Description : merge two sorted array
 *
 */
public class MergeArray2 {
	
	public static void main(String[] args) {
		int[] array1 = {1,2,4,55,66,113,157,182,192,201};
		int[] array2 = {40,45,66,70,120,140,160,200,1655,1732};
		
		int[] result = mergeArray(array1, array2);
		
		// distinct 
    // TODO
		
		for (int i = 0; i <= result.length-1; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
	
	
	private static int[] mergeArray(int[] array1, int[] array2) {
		if (array1 == null || array1.length == 0) {
			return array2;
		}
		
		if (array2 == null || array2.length == 0) {
			return array1;
		}
		
		int length1 = array1.length;
		int length2 = array2.length;
		
		int[] resultArray = new int[length1 + length2];
		
		// 若两个Arr中其中一个Arr的都比另一个大，则能直接合成
		if (array1[length1 -1] <= array2[0]) {
			resultArray = connectArray(array1, array2);
			return resultArray;
		}
		
		if (array2[length2 -1] <= array1[0]) {
			resultArray = connectArray(array2, array1);
			return resultArray;
		}
		
		// 取array1的第一个元素与array2的第一个元素比较小的一方，放入ResultArr,并使其索引+1，继续比较，直到最后
		int indexOfArray1 = 0;
		int indexOfArray2 = 0;
		int indexOfResult = 0;
		while (indexOfArray1 <= length1 -1 || indexOfArray2 <= length2 -1 ) {
			if (array1[indexOfArray1] < array2[indexOfArray2]) {
				resultArray[indexOfResult] = array1[indexOfArray1];
				indexOfArray1++;			
			} else {
				resultArray[indexOfResult] = array2[indexOfArray2];
				indexOfArray2++;
			}
			
			// 其中一方的数组已经全部遍历，将余下的数组部分写入ResultArr,全部遍历完毕则因为IndexOfXX++的原因应该是正好等于Arr.Length
			if(indexOfArray1 > length1 -1) {
				resultArray = addArray(resultArray, indexOfResult + 1, array2, indexOfArray2);
				return resultArray;
			}
			
			if (indexOfArray2 > length2 -1) {
				resultArray = addArray(resultArray, indexOfResult + 1, array1, indexOfArray1);
				return resultArray;
			}			
			indexOfResult++;
		}					
		return resultArray;			
	}
	
	
	private static int[] connectArray(int[] array1, int[] array2) {
		int[] resultArray = new int[array1.length + array2.length];
		
		System.arraycopy(array1, 0, resultArray, 0, array1.length);
		System.arraycopy(array2, 0, resultArray, array1.length, array2.length);
		
		return resultArray;
	}
	
	private static int[] addArray(int[] resultArray, int resultIndex, int addArray[], int addIndex) {
		while (addIndex <= addArray.length -1) {
			resultArray[resultIndex] = addArray[addIndex];
			addIndex++;
			resultIndex++;
		}	
		return resultArray;
	}

}
