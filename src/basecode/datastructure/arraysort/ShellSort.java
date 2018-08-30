package basecode.datastructure.arraysort;

public class ShellSort {
	
	public void shellSort(int [] array) {
		if(array.length < 2) {
			return;
		}
		int gap = array.length / 2;
		while(gap >= 1) {
			for (int i = gap; i < array.length ; i += gap) {
				int previous = i;
				while(previous > 0 && array [previous] < array [previous-gap] ) {
					int temp = array[previous];
					array[previous] = array [previous - gap];
					array[previous - gap] = temp;
					previous -= gap;
				}
			}
			gap /= 2;
		}
	}
}
