package basecode.datastructure.arraysort;

public class InsertSort {
	public void insertSort(int[] array) {
		if (array.length == 0 || array.length == 1) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			int previous = i;
			while (previous > 0 && array[previous] < array[previous - 1]) {
				int temp = array[previous];
				array[previous] = array[previous - 1];
				array[previous - 1] = temp;
				previous--;
			}
		}
	}
}
