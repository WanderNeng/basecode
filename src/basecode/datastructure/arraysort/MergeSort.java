package basecode.datastructure.arraysort;

import java.util.Arrays;

public class MergeSort {
	
	public int[] mergeSort(int[] array) {
		if(array.length == 0 || array.length == 1) {
			return array;
		}
		int[] arrleft = Arrays.copyOfRange(array, 0, array.length/2);
		int[] arrright = Arrays.copyOfRange(array, array.length/2, array.length);
		return merge(mergeSort(arrleft),mergeSort(arrright));
	}
	
	public int[] merge(int[] arrayleft, int[] arrayright) {
		int[] array = new int[arrayleft.length + arrayright.length];
		int cl = 0;
		int cr = 0;
		int count = 0;
		while(count < array.length) {
		if(cl > arrayleft.length-1) {
			array[count++] = arrayright[cr++]; 
		}else if(cr > arrayright.length-1) {
			array[count++] = arrayleft[cl++];
		}else if(arrayright[cr] > arrayleft[cl]) {
			array[count++] = arrayleft[cl++];
		}else {
			array[count++] = arrayright[cr++];
		}
		}
		return array;
	}
}
