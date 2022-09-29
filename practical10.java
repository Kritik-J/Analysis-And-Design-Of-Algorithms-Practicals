// 0/1 Knapsack Problem using Dynamic programming technique 

public class practical10 {

    public static int[][] knapsack(int n, int[] Wi, int[] Vi, int W) {
        int[][] V = new int[n][W];

        for (int i = 0; i < n; i++) {
            V[i][0] = 0;
        }

        for (int j = 1; j < W; j++) {
            V[0][j] = Vi[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < W; j++) {
                if (j - Wi[i] < 0) {
                    V[i][j] = V[i - 1][j];
                } else {
                    V[i][j] = Math.max(V[i - 1][j], Vi[i] + V[i - 1][(j - Wi[i])]);
                }
            }
        }

        return V;
    }

    public static void main(String[] args) {
        int[] w = { 1, 2, 2, 3 };
        int[] v = { 10, 12, 15, 30 };
        int W = 6;
        int n = w.length;

        int[][] V = knapsack(n, w, v, W);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(V[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
