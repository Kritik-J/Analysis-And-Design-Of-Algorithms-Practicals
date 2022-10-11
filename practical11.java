// Floyd’s algorithm for finding shortest path

public class practical11 {

    public static double[][] floyd(double[][] L) {
        int n = L.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    L[i][j] = Math.min(L[i][j], L[i][k] + L[k][j]);
                }
            }
        }

        return L;
    }

    public static void main(String[] args) {
        double inf = Double.POSITIVE_INFINITY;

        double[][] L = {
                { 0, inf, 3, inf },
                { 2, 0, inf, inf },
                { inf, 7, 0, 1 },
                { 6, inf, inf, 0 }
        };

        double[][] D = floyd(L);

        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D.length; j++) {
                System.out.print(String.format("%02.0f",D[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
