// Floyd’s algorithm for finding shortest path

public class practical11 {

    public static int[][] floyd(int[][] L) {
        int n = L.length;
        int[][] D = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = L[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }

        return D;
    }

    public static void main(String[] args) {
        // infinities are represented as 10000000

        int L[][] = {
                { 0, 100000, 3, 100000 },
                { 2, 0, 100000, 100000 },
                { 100000, 7, 0, 1 },
                { 6, 100000, 100000, 0 }
        };

        int D[][] = floyd(L);

        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D.length; j++) {
                System.out.print(D[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
