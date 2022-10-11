// Making Change Problem using Dynamic programming technique 

public class practical09 {
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int[][] makingChange(int[] d, int N) {
        int n = d.length;
        int[][] c = new int[n][N+1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 0 && j<d[i]) {
                    c[i][j]=-1;
                }   else if(i==0){
                    c[i][j] = j;
                }
                else if (d[i] > j) {
                    c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = min(c[i - 1][j], c[i][j - d[i]] + 1);
                }
            }
        }

        return c;
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5, 6 };
        int N = 10;
        int result[][] = makingChange(coins, N);

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(result[i][j] + " ");
                if(i== coins.length-1 && j == N){
                    System.out.println("\n\nMinimum coins: " + result[i][j]);
                }
            }
            System.out.println();
        }
    }
}