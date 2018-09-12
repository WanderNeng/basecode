package basecode.datastructure.LRU;

public class Way1 {

    int[][] data = new int[2][10];//使用数组实现LRU，每个元素都有一个时间戳

    //data[0][i]为任务名 data[1][i]为使用计数
    public void LRU(int task){
        if(contains(data,task)) {
            for (int i = 0; i < data[0].length; i++) {
                if (data[0][i] == task || data[0][i] == 0) {
                    data[1][i] = 0;
                } else {
                    data[1][i]++;
                }
            }
        }else {
            boolean flag = false;
            for (int i = 0; i < data[0].length; i++) {
                if (data[0][i] == 0 && !flag) {
                    data[0][i] = task;
                    data[1][i] = 0;
                    flag = true;
                }else{
                    data[1][i]++;
                }
            }
        }
    }

    private boolean contains(int[][] data, int task){
        for(int i = 0; i < data[0].length; i++){
            if(data[0][i] == task){
                return true;
            }

        }
        return false;
    }


}
