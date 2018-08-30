package basecode.datastructure.arraysort;

public class QuickSort {

	public void quickSort(int[] array) {
		if (array.length < 2) {
			return;
		}
		quick(array, 0, array.length - 1);
	}

	private void quick(int[] array, int start, int end) {
		if (end < start || start < 0 || end > array.length) {
			return;
		}
		int pivot = (int) (Math.random() * (end - start+1) + start);
		swap(array, pivot, end);
		int smallIndex = start - 1;
		int count = start;
		while (count <= end) {
			if (array[count] <= array[end]) {
				smallIndex++;
				if (count > smallIndex) {
					swap(array, smallIndex, count);
				}
			}
			count++;
		}
		 if (smallIndex > start)
	           quick(array, start, smallIndex - 1);
	       if (smallIndex < end)
	           quick(array, smallIndex + 1, end);

	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
