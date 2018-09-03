package basecode.datastructure.arraysort;

public class Test {

    public static void main(String[] args) {
        int[] array = new int[]{12, 35, 6, 2, 45, 34, 66, 24, 55, 15, 4, 43, 56, 32, 40, 19, 39, 20, 72};
//		分别是排序名称，最坏时间复杂度，最好时间复杂度，空间复杂度，内外排序，是否稳定排序
//		new PopSort().popSort(array); // 冒泡排序 n方 n 1 内 稳定
//		new InsertSort().insertSort(array);//插入排序 n方 n 1 内 稳定
//		new ChooseSort().chooseSort(array);// 选择排序 n方 n方 1 内 稳定
//		int[] array1 = new MergeSort().mergeSort(array);//归并排序 nlog2n log2n n 稳定
//		new ShellSort().shellSort(array);//希尔排序 时间复杂度不知，gap取二分之一的话，应该是log2n的方，空间复杂度 n，内，稳定
//		new QuickSort().quickSort(array);//快速排序 时间复杂度nlogn 空间复杂度 1，内，不稳定
        new HeapSort().heapSort(array); //堆排序 时间复杂度nlogn 空间复杂度 1， 内，不稳定
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}
