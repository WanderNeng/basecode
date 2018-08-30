package basecode.datastructure.arraysort;

public class ChooseSort {

	public void chooseSort(int[] array) {
		if (array.length == 0 || array.length == 1) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			int len = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[len]) {
					len = j;
				}
			}
			if (len != i) {
				int temp = array[i];
				array[i] = array[len];
				array[len] = temp;
			}

		}

	}
}
