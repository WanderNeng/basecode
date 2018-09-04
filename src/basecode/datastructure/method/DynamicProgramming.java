package basecode.datastructure.method;

//背包问题，0/1问题
public class DynamicProgramming {

    public static void main(String[] args) {

        int m = 10;
        int w[] = {5, 3, 4, 5, 2};
        int p[] = {3, 4, 5, 6, 3};
        int c[][] = dynamic(m, w, p);
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }

    }

    /*
        @param capacity 背包的容量
        @param n 物品数
        @param weight 物品重量数组
        @param value 物品价值数组

     */
    public static int[][] dynamic(int capacity, int[] weight, int[] value) {
        int n = weight.length;
        int[][] c = new int[n + 1][capacity + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (weight[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - weight[i - 1]] + value[i - 1]))
                        c[i][j] = c[i - 1][j - weight[i - 1]] + value[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c;
    }

}
