// Fractional Knapsack Problem using greedy technique 

public class practical4 {
    public static void knapsack(double capacity, double[] weight, double[] profit) {

        int n = weight.length;
        double x[] = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = 0.0;
        }

        double w = 0.0;
        int i = 0;

        while (w < capacity) {
            if (weight[i] <= capacity - w) {
                x[i] = 1.0;
                w = w + weight[i];
            } else {
                x[i] = (capacity - w) / weight[i];
                w = capacity;
            }
            i++;
        }

        for (int j = 0; j < n; j++) {
            System.out.print(x[j] + " ");
        }
    }

    public static void main(String[] args) {
        double[] weight = { 10, 20, 40, 50 };
        double[] profit = { 60, 80, 100, 120 };
        double capacity = 80;
        knapsack(capacity, weight, profit);
    }
}
