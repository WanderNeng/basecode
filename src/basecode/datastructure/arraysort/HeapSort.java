package basecode.datastructure.arraysort;

public class HeapSort {

    int len;

    public void heapSort(int[] array){
        int len = array.length;

        if(len < 1){return;}

        buildHeap(array);
        //循环将首位最大值与末位换
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }

    }

    //创建二叉树
    public void buildHeap(int[] array){
        //从最后一个非叶子节点开始向上构建最大堆
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    public void adjustHeap(int[] array, int i){
        int maxIndex = i;

        if(i*2 < len && array[i*2] > array[maxIndex]){
            maxIndex = 2*i;
        }

        if(i*2+1 < len && array[i*2+1] > array[maxIndex]){
            maxIndex = 2*i + 1;
        }

        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
